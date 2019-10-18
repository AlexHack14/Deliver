package oleksii.radyuk.delivery.dto.trailer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TrailerRequest {
    private String mark;
    private String model;
    @NotNull
    private String VIN;
    @NotBlank(message = "Cannot be empty")
    private String carNumber;
    private int year;
}
