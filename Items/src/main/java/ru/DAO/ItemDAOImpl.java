package ru.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDAOImpl implements ItemDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getCostByItemsID(String IDs) {
        return jdbcTemplate.queryForObject("select SUM(price) from items where id in (?)", new Object[] {IDs}, ROW_MAPPER);
    }

    @Override
    public List<String> getPricesByItemsID(String IDs) {
        return jdbcTemplate.query("select price from items where id in (" + IDs + ")", ROW_MAPPER);
    }


}
