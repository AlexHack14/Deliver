package oleksii.radyuk.delivery.dto.trailer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrailerResponse {
    private Long id;
    private String mark;
    private String model;
    private String VIN;
    private String carNumber;
    private int year;
}
