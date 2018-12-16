package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.CartItem;
import ru.Service.CartService;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "cart/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<CartItem> getItems(@PathVariable int user_id)
    {
        return cartService.items(user_id);
    }

    @RequestMapping(value = "cart/{user_id}/{item_id}", method = RequestMethod.PUT)
    @ResponseBody
    public String addItem(@PathVariable int user_id, @PathVariable int item_id)
    {
        cartService.addItem(user_id, item_id);
        return "ok";
    }

    @RequestMapping(value = "cart/{user_id}/{item_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteItem(@PathVariable int user_id, @PathVariable int item_id)
    {
        cartService.deleteItem(user_id, item_id);
        return "ok";
    }

    @RequestMapping(value = "cart/buy/{user_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String buy(@PathVariable int user_id) {
        return cartService.buy(user_id);
    }
}
