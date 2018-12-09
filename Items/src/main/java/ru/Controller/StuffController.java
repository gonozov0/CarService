package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.Service.StuffService;
import ru.Stuff;

import java.util.List;

@Controller
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @RequestMapping(value = "stuff", method = RequestMethod.GET)
    @ResponseBody
    public List<Stuff> getStuffs() {
        return stuffService.findAll();
    }

    @RequestMapping(value = "stuff/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String postStuff(@RequestBody Stuff stuff, @PathVariable int id) {
        stuff.setId(id);
        stuffService.save(stuff);
        return "ok";
    }

    @RequestMapping(value = "stuff", method = RequestMethod.PUT)
    @ResponseBody
    public String putStuff(@RequestBody Stuff stuff) {
        stuff.setId(-1);
        stuffService.save(stuff);
        return "ok";
    }

    @RequestMapping(value = "stuff/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteStuff(@PathVariable int id) {
        stuffService.delete(id);
        return "ok";
    }
    
}
