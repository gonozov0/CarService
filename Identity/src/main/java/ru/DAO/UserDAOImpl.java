package ru.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.User;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByLogin(String login) {
        return userExist(login) ? jdbcTemplate.queryForObject("select * from users where login = ?", new Object[]{login}, ROW_MAPPER) : null;
    }

    @Override
    public void addUser(String login, String password, String role) {
        jdbcTemplate.update("insert into users (login, password, role) values(?,?,?)", login, password, role);
    }

    private boolean userExist(String login) {
        return jdbcTemplate.queryForObject("select count(id) as count from users where login = ?", new Object[]{login}, KEY_MAPPER) > 0;
    }
}
