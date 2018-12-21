package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CSController {

    @Autowired
    private CSService csService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Config getConfig() {
        return csService.getConfig();
    }
}
