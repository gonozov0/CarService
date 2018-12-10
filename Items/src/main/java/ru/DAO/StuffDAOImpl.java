package ru.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.Stuff;

import java.util.List;

@Component
public class StuffDAOImpl implements StuffDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StuffDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Stuff> findAll() {
        return jdbcTemplate.query("select * from items where isCar=0", ROW_MAPPER);
    }

    @Override
    public Stuff findOne(int id) {
        Stuff stuff = jdbcTemplate.queryForObject("select * from items where id = ?", new Object[]{id}, ROW_MAPPER);
        return stuff;
    }

    @Override
    public void save(Stuff stuff) {
        if (stuff.getId() == -1) {
            jdbcTemplate.update("insert into items (name, type, price) values (?, ?, ?)", stuff.getName(), stuff.getType(), stuff.getPrice());
        }
        else {
            jdbcTemplate.update("update items set name = ?2, type = ?3, price = ?4 where id = ?1", stuff.getId(), stuff.getName(), stuff.getType(), stuff.getPrice());
        }
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from items where id = ?", id);
    }
}
