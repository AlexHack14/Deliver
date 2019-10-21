package oleksii.radyuk.delivery.service;


import oleksii.radyuk.delivery.dto.other.PageResponse;
import oleksii.radyuk.delivery.dto.other.PaginationRequest;
import oleksii.radyuk.delivery.dto.trailer.TrailerResponse;
import oleksii.radyuk.delivery.dto.trip.TripCriteriaRequest;
import oleksii.radyuk.delivery.dto.trip.TripRequest;
import oleksii.radyuk.delivery.dto.trip.TripResponse;
import oleksii.radyuk.delivery.entity.Car;
import oleksii.radyuk.delivery.entity.Driver;
import oleksii.radyuk.delivery.entity.Trailer;
import oleksii.radyuk.delivery.entity.Trip;
import oleksii.radyuk.delivery.repository.TripRepository;
import oleksii.radyuk.delivery.specification.TripSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TrailerService trailerService;

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    public void create(TripRequest tripRequest){
        Trip trip=requestToTrip(new Trip(),tripRequest);
        tripRepository.save(trip);
    }

    public PageResponse<TripResponse> findAll(PaginationRequest paginationRequest) {
        Page<Trip> page = tripRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(
                page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(this::tripToTripResponse).collect(Collectors.toList())
        );
    }

    public PageResponse<TripResponse> findAllByCriteria(PaginationRequest paginationRequest,TripCriteriaRequest request) {
        TripSpecification tripSpecifications = new TripSpecification(request);
        Page<Trip> page = tripRepository.findAll(tripSpecifications,paginationRequest.toPageable());
        return new PageResponse<>(
                page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(this::tripToTripResponse).collect(Collectors.toList())
        );
    }

    public void update(Long id, TripRequest request) {
        Trip trip = requestToTrip(findOne(id), request);
        tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.delete(findOne(id));
    }


    public Trip findOne(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car with id " + id + " not exists"));
    }

    public TripResponse findOneResponse(Long id) {
        return tripToTripResponse(findOne(id));
    }

    private TripResponse tripToTripResponse(Trip trip) {
        TripResponse tripResponse = new TripResponse();
        tripResponse.setId(trip.getId());
        tripResponse.setDate(trip.getDate());
        tripResponse.setFuelBuy(trip.getFuelBuy());
        tripResponse.setFuelUse(trip.getFuelUse());
        tripResponse.setAmountDay(trip.getAmountDay());
        tripResponse.setEuropeRange(trip.getEuropeRange());
        tripResponse.setUkraineRange(trip.getUkraineRange());
        tripResponse.setDriverSalaryEuro(trip.getDriverSalaryEuro());
        tripResponse.setDriverSalaryUa(trip.getDriverSalaryUa());
        tripResponse.setDriverSalaryZl(trip.getDriverSalaryZl());
        tripResponse.setStartDestination(trip.getStartDestination());
        tripResponse.setEndDestination(trip.getEndDestination());
        Driver driver=trip.getDriver();
        if (driver!=null){
            tripResponse.setDriverResponse(DriverService.driverToDriverResponse(driver));
        }
        Car car=trip.getCar();
        if (car!=null){
            tripResponse.setCarResponse(CarService.carToCarResponse(car));
        }
        Trailer trailer=trip.getTrailer();
        if (trailer!=null){
            tripResponse.setTrailerResponse(TrailerService.trailerToTrailerResponse(trailer));

        }
        return tripResponse;
    }

    private Trip requestToTrip(Trip trip, TripRequest request) {
        trip.setDate(request.getDate());
        trip.setFuelBuy(request.getFuelBuy());
        trip.setFuelUse(request.getFuelUse());
        trip.setAmountDay(request.getAmountDay());
        trip.setEuropeRange(request.getEuropeRange());
        trip.setUkraineRange(request.getUkraineRange());
        trip.setDriverSalaryUa(request.getUkraineRange());
        trip.setDriverSalaryEuro(request.getEuropeRange());
        trip.setDriverSalaryZl(request.getAmountDay()*100.0);
        trip.setCar(carService.findOne(request.getCarId()));
        trip.setTrailer(trailerService.findOne(request.getTrailerId()));
        trip.setDriver(driverService.findOne(request.getDriverId()));
        trip.setStartDestination(request.getStartDestination());
        trip.setEndDestination(request.getEndDestination());
        return trip;
    }
    public List<TripResponse> findAll(String fieldName, Sort.Direction direction){
        List<Trip> all = tripRepository.findAll(Sort.by(direction, fieldName));
        return all.stream().map(this::tripToTripResponse).collect(Collectors.toList());
    }


}
