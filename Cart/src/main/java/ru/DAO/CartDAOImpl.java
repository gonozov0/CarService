package ru.DAO;

import org.h2.jdbc.JdbcPreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;
import ru.CartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class CartDAOImpl implements CartDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CartItem> findAll(int user_id) {
        return jdbcTemplate.query("select item_id, count(id) as count from Cart where user_id=" + user_id + " group by item_id", ROW_MAPPER);
    }

    @Override
    public void addItem(int user_id, int item_id) {
            jdbcTemplate.update("insert into cart (user_id, item_id) values (?, ?)", user_id, item_id);
    }

    @Override
    public void deleteItem(int user_id, int item_id) {
        jdbcTemplate.execute("delete from Cart where user_id = "+ user_id + " and item_id = "+ item_id);
    }

    @Override
    public void deleteAll(int id) {
        jdbcTemplate.execute("delete from Cart");
    }

}
