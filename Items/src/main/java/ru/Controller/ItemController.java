package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.Logger;
import ru.RequestObject;
import ru.Service.ItemService;

import java.io.IOException;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "user/items/cost", method = RequestMethod.POST)
    @ResponseBody
    public String getCostByItemsID(@RequestBody RequestObject IDs) throws IOException {
        String str = itemService.getCostByItemsID(IDs.getString());

        Logger.write("\tCost By Items ID was given");

        return str;
    }

    @RequestMapping(value = "user/items/price", method = RequestMethod.POST)
    @ResponseBody
    public RequestObject getPricesByItemsID(@RequestBody RequestObject IDs) throws IOException {
        RequestObject rq = new RequestObject(itemService.getPricesByItemsID(IDs.getString()));

        Logger.write("\tPrices By Items ID was given");

        return rq;
    }
}
