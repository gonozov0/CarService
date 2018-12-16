package ru.DAO;

import org.springframework.stereotype.Component;
import ru.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component
public class CarDAOImpl implements CarDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cars> findAll() {
        return jdbcTemplate.query("select * from items where isCar=1", ROW_MAPPER);
    }

    @Override
    public Cars findOne(int id) {
        Cars car = jdbcTemplate.queryForObject("select * from items where id = ?", new Object[]{id}, ROW_MAPPER);
        return car;
    }

    @Override
    public void save(Cars car) {
        if (car.getId() == -1) {
            jdbcTemplate.update("insert into items (company, model, color, price) values (?, ?, ?, ?)", car.getCompany(), car.getModel(), car.getColor(), car.getPrice());
        }
        else {
            jdbcTemplate.update("update items set company = ?2, model = ?3, color = ?4, price = ?5 where id = ?1", car.getId(), car.getCompany(), car.getModel(), car.getColor(), car.getPrice());
        }
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from items where id = ?", id);
    }
}