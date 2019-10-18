package oleksii.radyuk.delivery.controller;

import oleksii.radyuk.delivery.dto.driver.DriverRequest;
import oleksii.radyuk.delivery.dto.driver.DriverResponse;
import oleksii.radyuk.delivery.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService driverService;


    @PostMapping
    public void create(@RequestBody DriverRequest request){
        driverService.create(request);
    }

    @GetMapping
    public List<DriverResponse> findAll(
            @RequestParam(defaultValue = "surname") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        return driverService.findAll(fieldName, direction);
    }

    @GetMapping("/one")
    public DriverResponse findOne(@RequestParam Long id) {
        return driverService.findOneResponse(id);
    }

    @PutMapping
    public void update(@RequestParam Long id, @RequestBody DriverRequest request) {
        driverService.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        driverService.delete(id);
    }
}
