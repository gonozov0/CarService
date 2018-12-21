package ru.Controller;

import ru.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.Service.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "user/car", method = RequestMethod.GET)
    @ResponseBody
    public List<Cars> getCars() {
        return carService.findAll();
    }

    @RequestMapping(value = "adm/car/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String postCar(@RequestBody Cars car, @PathVariable int id) {
        car.setId(id);
        carService.save(car);
        return "ok";
    }

    @RequestMapping(value = "adm/car", method = RequestMethod.PUT)
    @ResponseBody
    public String putCar(@RequestBody Cars car) {
        car.setId(-1);
        carService.save(car);
        return "ok";
    }

    @RequestMapping(value = "adm/car/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCar(@PathVariable int id) {
        carService.delete(id);
        return "ok";
    }
}
