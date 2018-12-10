package ru.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.Cars;
import ru.User;
import ru.DAO.CartDAOImpl;

import java.util.List;

@Service
public class CartService {

    private CartDAOImpl cartDAO;

    @Autowired
    public CartService(CartDAOImpl cartDAO) {
        this.cartDAO = cartDAO;
    }

    public void putPet(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cars[]> car = restTemplate.getForEntity("http://localhost:8081/pet/?", Cars[].class, id);

        if (car.getBody().length != 0) {
            cartDAO.addItem(id, car.getBody()[0].getPrice());
        }
    }

    public void putStaff(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Staff[]> staff = restTemplate.getForEntity("http://localhost:8081/staff/", Staff[].class);

        if (staff.getBody().length != 0) {
            cartDataAccessObject.addItem(id, staff.getBody()[0].getPrice());
        }
    }
    
}
