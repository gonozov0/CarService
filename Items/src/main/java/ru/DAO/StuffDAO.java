package ru.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.Stuff;

import java.sql.ResultSet;
import java.util.List;

public interface StuffDAO {
    // Маппер, превращающий строку из таблицы БД в объект класса Cars
    RowMapper<Stuff> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Stuff(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("type"), resultSet.getInt("price"));
    };
    RowMapper<Integer> KEY_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return resultSet.getInt("id");
    };

    List<Stuff> findAll();

    Stuff findOne(int id);

    void save(Stuff car);

    int delete(int id);
}
