package oleksii.radyuk.delivery.controller;

import oleksii.radyuk.delivery.dto.other.PageResponse;
import oleksii.radyuk.delivery.dto.other.PaginationRequest;
import oleksii.radyuk.delivery.dto.trip.TripCriteriaRequest;
import oleksii.radyuk.delivery.dto.trip.TripRequest;
import oleksii.radyuk.delivery.dto.trip.TripResponse;
import oleksii.radyuk.delivery.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trip")
@CrossOrigin

public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping
    public void create(@Valid @RequestBody TripRequest tripRequest) {
        tripService.create(tripRequest);
    }

    @GetMapping
    public List<TripResponse> findAll(
            @RequestParam(defaultValue = "id") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        return tripService.findAll(fieldName, direction);
    }

    @GetMapping("/page")
    public PageResponse<TripResponse> findAll(PaginationRequest paginationRequest) {
        return tripService.findAll(paginationRequest);
    }

    @GetMapping("/one")
    public TripResponse findOne(@RequestParam Long id) {
        return tripService.findOneResponse(id);
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
    public PageResponse<TripResponse> findAllByCriteria(TripCriteriaRequest request,PaginationRequest paginationRequest) {
        return tripService.findAllByCriteria(paginationRequest, request);
    }
}
