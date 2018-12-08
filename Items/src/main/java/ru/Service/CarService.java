package ru.Service;

import org.springframework.stereotype.Service;
import ru.DAO.CarsDAO;
import ru.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.DAO.CarsDAOImpl;

import java.util.List;

@Service
public class CarService {

    private CarsDAOImpl carDAO;

    @Autowired
    public CarService(CarsDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    public List<Cars> findAll() {
        return carDAO.findAll();
    }

    public Cars findOne(int id) { return carDAO.findOne(id); }

    public Cars save(Cars car) { return carDAO.save(car); }

    public int delete(int id) { return carDAO.delete(id); }

}
