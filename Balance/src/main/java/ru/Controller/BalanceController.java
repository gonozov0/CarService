package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.Balance;
import ru.Service.BalanceService;

import java.util.List;

@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @RequestMapping(value = "balance/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public String getBalance(@PathVariable int user_id)
    {
        return balanceService.balance(user_id);
    }

    @RequestMapping(value = "balance", method = RequestMethod.POST)
    @ResponseBody
    public String updateBalance(@RequestBody Balance balance)
    {
        balanceService.updateUserBalance(balance.getMoney(), balance.getUser_id());
        return "ok";
    }

    @RequestMapping(value = "balance", method = RequestMethod.PUT)
    @ResponseBody
    public String putBalance(@RequestBody Balance balance)
    {
        balanceService.updateUserBalance(balance.getMoney(), balance.getUser_id());
        return "ok";
    }
}
