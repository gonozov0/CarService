package ru.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.Logger;
import ru.Service.IdentityService;
import ru.Token;
import ru.User;

@Controller
public class IdentityController {

    @Autowired
    private IdentityService identityService;

    @RequestMapping(value = "sign/in", method = RequestMethod.POST)
    @ResponseBody
    public Token getToken(@RequestBody User user) throws Exception {
        Token token = identityService.getToken(user.getLogin(), user.getPassword());

        Logger.write("Token: " + token.info() + " was given");

        return token;
    }

    @RequestMapping(value = "sign/up", method = RequestMethod.POST)
    @ResponseBody
    public Token addUser(@RequestBody User user) throws Exception {
        return identityService.addUser(user.getLogin(), user.getPassword());
    }
}
