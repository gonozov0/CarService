package ru.DAO;

import org.springframework.stereotype.Component;
import ru.Cars;
import org.springframework.jdbc.core.RowMapper;
import ru.Stuff;

import java.sql.ResultSet;
import java.util.List;

@Component
public interface CarDAO {

    // Маппер, превращающий строку из таблицы БД в объект класса Cars
    RowMapper<Cars> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Cars(resultSet.getInt("id"), resultSet.getString("company"), resultSet.getString("model"), resultSet.getString("color"), resultSet.getInt("price"));
    };
    RowMapper<Integer> KEY_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return resultSet.getInt("id");
    };

    List<Cars> findAll();

    Cars findOne(int id);

    void save(Cars car);

    int delete(int id);
}

