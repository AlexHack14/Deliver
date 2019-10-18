package oleksii.radyuk.delivery.controller;

import oleksii.radyuk.delivery.dto.trailer.TrailerRequest;
import oleksii.radyuk.delivery.dto.trailer.TrailerResponse;
import oleksii.radyuk.delivery.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trailer")
@CrossOrigin
public class TrailerController {
    @Autowired
    private TrailerService trailerService;

    @GetMapping
    public List<TrailerResponse> findAll(
            @RequestParam(defaultValue = "mark") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        return trailerService.findAll(fieldName, direction);
    }

    @PostMapping
    public void create(@RequestBody TrailerRequest request){
        trailerService.create(request);
    }

    @GetMapping("/one")
    public TrailerResponse findOne(@RequestParam Long id) {
        return trailerService.findOneResponse(id);
    }

    @PutMapping
    public void update(@RequestParam Long id, @RequestBody TrailerRequest request) {
        trailerService.update(id, request);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        trailerService.delete(id);
    }
}
