package oleksii.radyuk.delivery.dto.car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
    private Long id;
    private String mark;
    private String model;
    private String VIN;
    private String carNumber;
    private int year;
}
