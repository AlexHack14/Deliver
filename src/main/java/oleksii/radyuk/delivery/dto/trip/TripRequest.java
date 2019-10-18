package oleksii.radyuk.delivery.dto.trip;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Getter
@Setter
public class TripRequest {
    private Date date;
    private double fuelBuy;
    private double fuelUse;
    private int amountDay;
    private double ukraineRange;
    private double europeRange;
    @NotNull
    private Long carId;
    @NotNull
    private Long trailerId;
    @NotNull
    private Long driverId;

}
