package ru.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
/*
    @Override
    public List<CartItem> findAll(int user_id) {
        return jdbcTemplate.query("select item_id, count(id) as count from Carts where user_id=" + user_id + " group by item_id", ROW_MAPPER);
    }

    @Override
    public void addItem(int user_id, int item_id) {
        Integer id = jdbcTemplate.query("select id from cart where user_id = " + user_id + " and item_id = " + item_id, KEY_MAPPER).get(0);
        if (id.toString().isEmpty()) {
            jdbcTemplate.update("insert into cart (user_id, item_id) values (?, ?)", user_id, item_id);
        } else {
            jdbcTemplate.update("update cart set user_id = ?2, item_id = ?3 where id = ?1", id, user_id, item_id);
        }
    }

    @Override
    public void deleteItem(int id) {
        jdbcTemplate.execute("delete from Cart where id =" + id);
    }

    @Override
    public void deleteAll(int id) {
        jdbcTemplate.execute("delete from Carts");
    }
*/
}
