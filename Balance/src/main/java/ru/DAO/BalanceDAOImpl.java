package ru.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.Balance;

import java.util.List;

@Component
public class BalanceDAOImpl implements BalanceDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BalanceDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Balance> getBalance() {
        return jdbcTemplate.query("select * from Balance", ROW_MAPPER);
    }

    @Override
    public String getBalanceByUserID(int id) {
        return jdbcTemplate.queryForObject("select money from Balance where USER_ID = ?", new Object[] {id}, MONEY_MAPPER);
    }

    @Override
    public void updateUserBalance(double newBalance, int id) {
        if (jdbcTemplate.query("SELECT * from Balance where user_id = " + id, ROW_MAPPER).isEmpty()) {
            jdbcTemplate.update("insert into balance values (?, ?)", id, newBalance);
        }
        else {
            jdbcTemplate.execute("UPDATE BALANCE set MONEY = " + newBalance + " where USER_ID = " + id);
        }
    }
}
