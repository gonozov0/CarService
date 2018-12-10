package ru.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.CartItem;
import ru.User;

import java.sql.ResultSet;
import java.util.List;

public interface CartDAO {
    // Маппер, превращающий строку из таблицы БД в объект класса Cars
    RowMapper<CartItem> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new CartItem(resultSet.getInt("item_id"), resultSet.getInt("count"));
    };
    RowMapper<Integer> KEY_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return resultSet.getInt("id");
    };

    public List<CartItem> findAll(int user_id);

    public void addItem(int user_id, int item_id);

    public void deleteItem(int id);

    public void deleteAll(int id);

}
