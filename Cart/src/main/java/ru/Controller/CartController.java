package ru.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.CartItem;
import ru.Service.CartService;
import ru.Token;

import java.io.IOException;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "user/cart", method = RequestMethod.GET)
    @ResponseBody
    public List<CartItem> getItems(@RequestHeader HttpHeaders hh) throws IOException {
        String tokenStr = hh.get("token").get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        Token token = objectMapper.readValue(tokenStr, Token.class);
        return cartService.items(token.getUserID());
    }

    @RequestMapping(value = "user/cart/{item_id}", method = RequestMethod.PUT)
    @ResponseBody
    public String addItem(@RequestHeader HttpHeaders hh, @PathVariable int item_id) throws IOException {
        String tokenStr = hh.get("token").get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        Token token = objectMapper.readValue(tokenStr, Token.class);
        cartService.addItem(token.getUserID(), item_id);
        return "ok";
    }

    @RequestMapping(value = "user/cart/{item_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteItem(@RequestHeader HttpHeaders hh, @PathVariable int item_id) throws IOException {
        String tokenStr = hh.get("token").get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        Token token = objectMapper.readValue(tokenStr, Token.class);
        cartService.deleteItem(token.getUserID(), item_id);
        return "ok";
    }

    @RequestMapping(value = "user/cart/buy", method = RequestMethod.DELETE)
    @ResponseBody
    public String buy(@RequestHeader HttpHeaders hh) throws IOException {
        String tokenStr = hh.get("token").get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        Token token = objectMapper.readValue(tokenStr, Token.class);
        return cartService.buy(token.getUserID());
    }
}
