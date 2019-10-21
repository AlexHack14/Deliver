package oleksii.radyuk.delivery.dto.trip;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class TripRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double fuelBuy;
    private double fuelUse;
    private int amountDay;
    private double ukraineRange;
    private double europeRange;
    private String startDestination;
    private String endDestination;
    @NotNull
    private Long carId;
    @NotNull
    private Long trailerId;
    @NotNull
    private Long driverId;

}
