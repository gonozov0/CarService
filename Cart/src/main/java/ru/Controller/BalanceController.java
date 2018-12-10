package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.User;
import ru.Service.CartService;

import java.util.List;

@Controller
public class BalanceController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "balance", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getBalance()
    {
        return cartService.balance();
    }

    @RequestMapping(value = "balance/{user_id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateBalance(@PathVariable int user_id, @RequestBody User user)
    {
        cartService.updateUserBalance(user.getMoney(), user_id);
        return "ok";
    }

    @RequestMapping(value = "balance/{user_id}", method = RequestMethod.PUT)
    @ResponseBody
    public String putBalance(@PathVariable int user_id, @RequestBody User user)
    {
        cartService.updateUserBalance(user.getMoney(), user_id);
        return "ok";
    }
}
