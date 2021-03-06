package ru.Service;

import org.springframework.stereotype.Service;
import ru.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import ru.DAO.CarDAOImpl;

import java.util.List;

@Service
public class CarService {

    private CarDAOImpl carDAO;

    @Autowired
    public CarService(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    public List<Cars> findAll() {
        return carDAO.findAll();
    }

    public Cars findOne(int id) { return carDAO.findOne(id); }

    public void save(Cars car) { carDAO.save(car); }

    public int delete(int id) { return carDAO.delete(id); }

}
