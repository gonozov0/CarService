package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.RequestObject;
import ru.Service.ItemService;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "items/cost", method = RequestMethod.POST)
    @ResponseBody
    public String getCostByItemsID(@RequestBody RequestObject IDs) {
        return itemService.getCostByItemsID(IDs.getString());
    }

    @RequestMapping(value = "items/price", method = RequestMethod.POST)
    @ResponseBody
    public RequestObject getPricesByItemsID(@RequestBody RequestObject IDs) {
        return new RequestObject(itemService.getPricesByItemsID(IDs.getString()));
    }
}
