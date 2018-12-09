package ru.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.DAO.StuffDAOImpl;
import ru.Stuff;

import java.util.List;

@Service
public class StuffService {

    private StuffDAOImpl stuffDAO;

    @Autowired
    public StuffService(StuffDAOImpl stuffDAO) {
        this.stuffDAO = stuffDAO;
    }

    public List<Stuff> findAll() {
        return stuffDAO.findAll();
    }

    public Stuff findOne(int id) { return stuffDAO.findOne(id); }

    public void save(Stuff stuff) { stuffDAO.save(stuff); }

    public int delete(int id) { return stuffDAO.delete(id); }
    
}
