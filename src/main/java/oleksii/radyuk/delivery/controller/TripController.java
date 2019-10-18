package oleksii.radyuk.delivery.controller;

import oleksii.radyuk.delivery.dto.other.PageResponse;
import oleksii.radyuk.delivery.dto.other.PaginationRequest;
import oleksii.radyuk.delivery.dto.trip.TripCriteriaRequest;
import oleksii.radyuk.delivery.dto.trip.TripRequest;
import oleksii.radyuk.delivery.dto.trip.TripResponse;
import oleksii.radyuk.delivery.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping
    public void create(@Valid @RequestBody TripRequest tripRequest) {
        tripService.create(tripRequest);
    }

    @GetMapping
    public PageResponse<TripResponse> findAll(PaginationRequest paginationRequest) {
        return tripService.findAll(paginationRequest);
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody TripRequest carRequest) {
        tripService.update(id, carRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        tripService.delete(id);
    }


    @GetMapping("/find")
    public List<TripResponse> findAllByCriteria(TripCriteriaRequest request) {
        return tripService.findAllByCriteria(request);
    }
}
