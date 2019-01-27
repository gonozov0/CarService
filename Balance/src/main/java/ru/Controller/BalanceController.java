package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.Balance;
import ru.Logger;
import ru.Service.BalanceService;

import java.io.IOException;

@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @RequestMapping(value = "user/balance/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public String getBalance(@PathVariable int user_id) throws IOException {
        Logger.write("\tgetting balance for: " + Integer.toString(user_id));
        return balanceService.balance(user_id);
    }

    @RequestMapping(value = "adm/balance", method = RequestMethod.POST)
    @ResponseBody
    public String updateBalance(@RequestBody Balance balance) throws IOException {
        balanceService.updateUserBalance(balance.getMoney(), balance.getUser_id());
        Logger.write("\tupdating balance for: " + Integer.toString(balance.getUser_id()) + " to: " + Double.toString(balance.getMoney()));
        return "ok";
    }

    @RequestMapping(value = "adm/balance", method = RequestMethod.PUT)
    @ResponseBody
    public String putBalance(@RequestBody Balance balance)
    {
        balanceService.updateUserBalance(balance.getMoney(), balance.getUser_id());
        return "ok";
    }
}
