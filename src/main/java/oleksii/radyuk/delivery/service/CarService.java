package oleksii.radyuk.delivery.service;

import oleksii.radyuk.delivery.dto.car.CarRequest;
import oleksii.radyuk.delivery.dto.car.CarResponse;
import oleksii.radyuk.delivery.entity.Car;
import oleksii.radyuk.delivery.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void create(CarRequest carRequest){
        Car car=new Car();
        car.setCarNumber(carRequest.getCarNumber());
        car.setMark(carRequest.getMark());
        car.setModel(carRequest.getModel());
        car.setVIN(carRequest.getVIN());
        car.setYear(carRequest.getYear());
        carRepository.save(car);
    }

    public List<CarResponse> findAll(String fieldName, Sort.Direction direction){
        List<Car> all = carRepository.findAll(Sort.by(direction, fieldName));
        return all.stream().map(CarService::carToCarResponse).collect(Collectors.toList());
    }

    public CarResponse findOneResponse(Long id) {
        return carToCarResponse(findOne(id));
    }

    public void update(Long id, CarRequest request) {
        Car car = findOne(id);
        car.setCarNumber(request.getCarNumber());
        car.setMark(request.getMark());
        car.setModel(request.getModel());
        car.setVIN(request.getVIN());
        car.setYear(request.getYear());
        carRepository.save(car);
    }

    public void delete(Long id) {
        Car car = findOne(id);
        if (car.getTripList().isEmpty()) {
            carRepository.delete(car);
        } else {
            throw new RuntimeException("Country with id " + id + " has dependencies");
        }
    }

    public Car findOne(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country with id " + id + " not exists"));
    }


    public static CarResponse carToCarResponse(Car car) {
        CarResponse cr = new CarResponse();
        cr.setId(car.getId());
        cr.setCarNumber(car.getCarNumber());
        cr.setMark(car.getMark());
        cr.setModel(car.getModel());
        cr.setVIN(car.getVIN());
        cr.setYear(car.getYear());
        return cr;
    }

}
