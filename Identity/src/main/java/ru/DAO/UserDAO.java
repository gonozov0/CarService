package ru.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDAO {
    // Маппер, превращающий строку из таблицы БД в объект класса Cars
    RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("role"));
    };
    RowMapper<Integer> KEY_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return resultSet.getInt("id");
    };

    /*public List<CartItem> findAll(int user_id);

    public void addItem(int user_id, int item_id);

    public void deleteItem(int id);

    public void deleteAll(int id);
*/
}
