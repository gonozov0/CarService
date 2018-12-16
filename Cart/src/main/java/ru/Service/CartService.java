package ru.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.Balance;
import ru.CartItem;
import ru.DAO.CartDAOImpl;
import ru.RequestObject;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    private CartDAOImpl cartDAO;

    @Autowired
    public CartService(CartDAOImpl cartDAO) {
        this.cartDAO = cartDAO;
    }

    public void addItem(int user_id, int item_id) {
        cartDAO.addItem(user_id, item_id);
    }

    public void deleteItem(int user_id, int item_id) {
        cartDAO.deleteItem(user_id, item_id);
    }

    public List<CartItem> items(int user_id) {
        List<CartItem> cartItems = cartDAO.findAll(user_id);
        if (cartItems.size() == 0) return null;
        List<String> IDs = cartItems.stream().map(cartItem -> Integer.toString(cartItem.getItem_id())).collect(Collectors.toList());
        RequestObject request = new RequestObject(IDs);
        RestTemplate restTemplate = new RestTemplate();
        RequestObject response = restTemplate.postForObject("http://localhost:8081/items/price", request, RequestObject.class);
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

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8083/balance/{user_id}", String.class, user_id);
        Double user_balance = Double.parseDouble(response);

        if (user_balance >= items_cost) {
            Balance balance = new Balance(user_id, user_balance-items_cost);
            for (CartItem cartItem: cartItems) {
                deleteItem(user_id, cartItem.getItem_id());
            }
            return restTemplate.postForObject("http://localhost:8083/balance/", balance, String.class);
        }
        else {
            return "Недостаточно сретств";
        }
    }
}
