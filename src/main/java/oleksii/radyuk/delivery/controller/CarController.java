package oleksii.radyuk.delivery.controller;

import oleksii.radyuk.delivery.dto.car.CarRequest;
import oleksii.radyuk.delivery.dto.car.CarResponse;
import oleksii.radyuk.delivery.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public void create(@RequestBody CarRequest request){
        carService.create(request);
    }

    @GetMapping
    public List<CarResponse> findAll(
            @RequestParam(defaultValue = "mark") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        return carService.findAll(fieldName, direction);
    }

    @GetMapping("/one")
    public CarResponse findOne(@RequestParam Long id) {
        return carService.findOneResponse(id);
    }

    @PutMapping
    public void update(@RequestParam Long id, @RequestBody CarRequest request) {
        carService.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        carService.delete(id);
    }

}
