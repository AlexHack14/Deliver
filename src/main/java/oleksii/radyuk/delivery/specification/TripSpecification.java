package oleksii.radyuk.delivery.specification;

import oleksii.radyuk.delivery.dto.trip.TripCriteriaRequest;
import oleksii.radyuk.delivery.entity.Car;
import oleksii.radyuk.delivery.entity.Driver;
import oleksii.radyuk.delivery.entity.Trailer;
import oleksii.radyuk.delivery.entity.Trip;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Date;

public class TripSpecification implements Specification<Trip> {
    private Long driverId;
    private Long carId;
    private Long trailerId;
    private Date date;
    private String startDestination;
    private String endDestination;

    public TripSpecification(TripCriteriaRequest request) {
        driverId = request.getDriverId();
        carId = request.getCarId();
        trailerId = request.getTrailerId();
        date = request.getDate();
        startDestination=request.getStartDestination();
        endDestination=request.getEndDestination();
    }


    @Override
    public Predicate toPredicate(Root<Trip> r, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        return cb.and(findByDriver(r,cb),findByCar(r,cb),findByTrailer(r,cb),findByDate(r,cb),findByStartDestination(r,cb),findByEndDestination(r,cb));
    }

    private Predicate findByDriver(Root<Trip> r, CriteriaBuilder cb){
        Predicate predicate;
        if (driverId!=null){
            Join<Trip, Driver> driver=r.join("driver");
            predicate=cb.equal(driver.get("id"),driverId);
        }else{
            predicate=cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByCar(Root<Trip> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (carId != null) {
            Join<Trip, Car> car = r.join("car");
            predicate = cb.equal(car.get("id"), carId);
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByTrailer(Root<Trip> r, CriteriaBuilder cb){
        Predicate predicate;
        if (trailerId!=null){
            Join<Trip, Trailer> trailer =r.join("trailer");
            predicate=cb.equal(trailer.get("id"),trailerId);
        }else{
            predicate=cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByDate(Root<Trip> r, CriteriaBuilder cb){
        Predicate predicate;
        if (date!=null){
            predicate=cb.equal(r.get("date"),date);
        }else{
            predicate=cb.conjunction();
        }


        return predicate;
    }

    private Predicate findByStartDestination(Root<Trip> r, CriteriaBuilder cb){
        Predicate predicate;
        if (startDestination!=null){
            predicate=cb.equal(r.get("startDestination"),startDestination);
        }else{
            predicate=cb.conjunction();
        }
        return predicate;
    }

    private Predicate findByEndDestination(Root<Trip> r, CriteriaBuilder cb){
        Predicate predicate;
        if (endDestination!=null){
            predicate=cb.equal(r.get("endDestination"),endDestination);
        }else{
            predicate=cb.conjunction();
        }
        return predicate;
    }
}
