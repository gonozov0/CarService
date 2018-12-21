package ru.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.*;
import ru.DAO.CartDAOImpl;
import org.apache.commons.codec.digest.DigestUtils;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    private CartDAOImpl cartDAO;
    private Config config;
    private String tokenStr;

    @Autowired
    public CartService(CartDAOImpl cartDAO) {
        this.cartDAO = cartDAO;
    }

    public void addItem(int user_id, int item_id) {
        cartDAO.addItem(user_id, item_id);
    }

    @PostConstruct
    public void init() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        this.config = restTemplate.getForObject("http://localhost:8085/", Config.class);

        String signature = DigestUtils.sha256Hex("-1" + "admin" + "123");
        Token token = new Token(-1, "admin", signature);

        ObjectMapper objectMapper = new ObjectMapper();
        this.tokenStr = objectMapper.writer().writeValueAsString(token);
    }

    public void deleteItem(int user_id, int item_id) {
        cartDAO.deleteItem(user_id, item_id);
    }

    public List<CartItem> items(int user_id) {
        List<CartItem> cartItems = cartDAO.findAll(user_id);
        if (cartItems.size() == 0) return null;
        List<String> IDs = cartItems.stream().map(cartItem -> Integer.toString(cartItem.getItem_id())).collect(Collectors.toList());
        RequestObject request = new RequestObject(IDs);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Token" , tokenStr);
        HttpEntity entity = new HttpEntity(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RequestObject> responseEntity = restTemplate.exchange(config.getItems() + "user/items/price", HttpMethod.POST, entity, RequestObject.class);
        RequestObject response = responseEntity.getBody();

        List<String> prices = response.toList();
        for (int i=0; i<cartItems.size(); i++) {
            cartItems.get(i).setPrice(Integer.parseInt(prices.get(i)));
        }
        return cartItems;
    }

    public String buy(int user_id) {
        List<CartItem> cartItems = items(user_id);
        if (cartItems == null) return "Корзина пуста";
        double items_cost = 0;
        for (CartItem cartItem: cartItems) {
            items_cost += cartItem.getPrice()*cartItem.getCount();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Token" , tokenStr);
        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(config.getBalance()+"user/balance/{user_id}", HttpMethod.GET, entity, String.class, user_id);
        String response = responseEntity.getBody();
        Double user_balance = Double.parseDouble(response);

        if (user_balance >= items_cost) {
            Balance balance = new Balance(user_id, user_balance-items_cost);
            for (CartItem cartItem: cartItems) {
                deleteItem(user_id, cartItem.getItem_id());
            }
            headers = new HttpHeaders();
            headers.set("Token" , tokenStr);
            entity = new HttpEntity(balance, headers);
            restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(config.getBalance()+"adm/balance/", HttpMethod.POST, entity, String.class);
            return responseEntity.getBody();
        }
        else {
            return "Недостаточно сретств";
        }
    }
}
