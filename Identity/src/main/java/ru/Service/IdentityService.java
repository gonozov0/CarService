package ru.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.DAO.UserDAO;
import ru.DAO.UserDAOImpl;
import ru.Token;
import ru.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.management.relation.Role;

@Service
public class IdentityService {

    private UserDAOImpl userDAO;
    private String key;

    @Autowired
    public IdentityService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
        this.key = "123";
    }

    public Token getToken(String login, String password) throws Exception {
        User user = userDAO.getUserByLogin(login);
        if (user == null) {
            throw new Exception("Вас нет в системе, пройдите регистрацию!!!");
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("Неверный пароль!!!");
        }
        String signature = DigestUtils.sha256Hex(Integer.toString(user.getId())+user.getRole()+key);
        return new Token(user.getId(), user.getRole(), signature);
    }

    public Token addUser(String login, String password) throws Exception {
        userDAO.addUser(login, password, "user");
        return getToken(login, password);
    }
}
