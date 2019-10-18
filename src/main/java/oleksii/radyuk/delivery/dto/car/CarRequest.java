package oleksii.radyuk.delivery.dto.car;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarRequest {
    private String mark;
    private String model;
    @NotNull
    private String VIN;
    @NotBlank(message = "Cannot be empty")
    private String carNumber;
    private int year;
}
