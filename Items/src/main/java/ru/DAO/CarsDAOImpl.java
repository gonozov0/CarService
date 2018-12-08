package ru.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component
public class CarsDAOImpl implements CarsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cars> findAll() {
        return jdbcTemplate.query("select * from Cars", ROW_MAPPER);
    }

    @Override
    public Cars findOne(int id) {
        Cars car = jdbcTemplate.queryForObject("select * from Cars where id = ?", new Object[]{id}, ROW_MAPPER);
        return car;
    }

    @Override
    public Cars save(Cars car) {
        if (car.getId() == -1) {
            jdbcTemplate.update("insert into Cars values (?, ?, ?, ?)", car.getCompany(), car.getModel(), car.getColor(), car.getPrice());
        }
        else {
            jdbcTemplate.update("update Cars set company = ?2, model = ?3, color = ?4, price = ?5 where id = ?1", car.getId(), car.getCompany(), car.getModel(), car.getColor(), car.getPrice());
        }

        return findOne(car.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from Cars where id = ?", id);
    }
}