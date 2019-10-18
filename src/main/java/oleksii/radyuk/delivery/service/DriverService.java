package oleksii.radyuk.delivery.service;

import oleksii.radyuk.delivery.dto.driver.DriverRequest;
import oleksii.radyuk.delivery.dto.driver.DriverResponse;
import oleksii.radyuk.delivery.entity.Driver;
import oleksii.radyuk.delivery.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public void create(DriverRequest driverRequest){
        Driver driver=new Driver();
        driver.setName(driverRequest.getName());
        driver.setSurname(driverRequest.getSurname());
        driverRepository.save(driver);
    }

    public List<DriverResponse> findAll(String fieldName, Sort.Direction direction){
        List<Driver> all = driverRepository.findAll(Sort.by(direction, fieldName));
        return all.stream().map(DriverService::driverToDriverResponse).collect(Collectors.toList());
    }

    public DriverResponse findOneResponse(Long id) {
        return driverToDriverResponse(findOne(id));
    }

    public void update(Long id, DriverRequest request) {
        Driver driver = findOne(id);
        driver.setName(request.getName());
        driver.setSurname(request.getSurname());
        driverRepository.save(driver);
    }

    public void delete(Long id) {
        Driver driver = findOne(id);
        if (driver.getTripList().isEmpty()) {
            driverRepository.delete(driver);
        } else {
            throw new RuntimeException("Country with id " + id + " has dependencies");
        }
    }


    public Driver findOne(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country with id " + id + " not exists"));
    }


    public static DriverResponse driverToDriverResponse(Driver driver) {
        DriverResponse dr = new DriverResponse();
        dr.setId(driver.getId());
        dr.setName(driver.getName());
        dr.setSurname(driver.getSurname());
        return dr;
    }
}
