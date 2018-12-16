package ru.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.Balance;

import java.sql.ResultSet;
import java.util.List;

public interface BalanceDAO {
    // Маппер, превращающий строку из таблицы БД в объект класса Cars
    RowMapper<Balance> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Balance(resultSet.getInt("user_id"), resultSet.getInt("money"));
    };

    RowMapper<String> MONEY_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return Double.toString(resultSet.getDouble("money"));
    };

    public List<Balance> getBalance();

    public String getBalanceByUserID(int id);

    public void updateUserBalance(double newBalance, int id);

}
