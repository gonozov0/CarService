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

    @RequestMapping(value = "balance", method = RequestMethod.GET)
    @ResponseBody
    public List<Balance> getBalance()
    {
        return balanceService.balance();
    }

    @RequestMapping(value = "balance/{user_id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateBalance(@PathVariable int user_id, @RequestBody Balance balance)
    {
        balanceService.updateUserBalance(balance.getMoney(), user_id);
        return "ok";
    }

    @RequestMapping(value = "balance/{user_id}", method = RequestMethod.PUT)
    @ResponseBody
    public String putBalance(@PathVariable int user_id, @RequestBody Balance balance)
    {
        balanceService.updateUserBalance(balance.getMoney(), user_id);
        return "ok";
    }
}
