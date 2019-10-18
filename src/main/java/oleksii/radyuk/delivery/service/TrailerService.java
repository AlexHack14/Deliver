package oleksii.radyuk.delivery.service;

import oleksii.radyuk.delivery.dto.driver.DriverRequest;
import oleksii.radyuk.delivery.dto.driver.DriverResponse;
import oleksii.radyuk.delivery.dto.trailer.TrailerRequest;
import oleksii.radyuk.delivery.dto.trailer.TrailerResponse;
import oleksii.radyuk.delivery.entity.Trailer;
import oleksii.radyuk.delivery.repository.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class TrailerService {
    @Autowired
    private TrailerRepository trailerRepository;

    public void create(TrailerRequest trailerRequest){
        Trailer trailer=new Trailer();
        trailer.setCarNumber(trailerRequest.getCarNumber());
        trailer.setMark(trailerRequest.getMark());
        trailer.setModel(trailerRequest.getModel());
        trailer.setVIN(trailerRequest.getVIN());
        trailer.setYear(trailerRequest.getYear());
        trailerRepository.save(trailer);
    }

    public List<TrailerResponse> findAll(String fieldName, Sort.Direction direction){
        List<Trailer> all = trailerRepository.findAll(Sort.by(direction, fieldName));
        return all.stream().map(TrailerService::trailerToTrailerResponse).collect(Collectors.toList());
    }

    public TrailerResponse findOneResponse(Long id) {
        return trailerToTrailerResponse(findOne(id));
    }

    public void update(Long id, TrailerRequest request) {
        Trailer trailer = findOne(id);
        trailer.setCarNumber(request.getCarNumber());
        trailer.setMark(request.getMark());
        trailer.setModel(request.getModel());
        trailer.setVIN(request.getVIN());
        trailer.setYear(request.getYear());
        trailerRepository.save(trailer);
    }

    public void delete(Long id) {
        Trailer trailer = findOne(id);
        if (trailer.getTripList().isEmpty()) {
            trailerRepository.delete(trailer);
        } else {
            throw new RuntimeException("Country with id " + id + " has dependencies");
        }
    }


    public Trailer findOne(Long id) {
        return trailerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country with id " + id + " not exists"));
    }


    public static TrailerResponse trailerToTrailerResponse(Trailer trailer) {
        TrailerResponse cr = new TrailerResponse();
        cr.setId(trailer.getId());
        cr.setCarNumber(trailer.getCarNumber());
        cr.setMark(trailer.getMark());
        cr.setModel(trailer.getModel());
        cr.setVIN(trailer.getVIN());
        cr.setYear(trailer.getYear());
        return cr;
    }
}
