package ru.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.Cars;

import java.sql.ResultSet;
import java.util.List;

public interface ItemDAO {
    RowMapper<String> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return Integer.toString(resultSet.getInt("price"));
    };

    public String getCostByItemsID(String IDs);

    public List<String> getPricesByItemsID(String IDs);
}
