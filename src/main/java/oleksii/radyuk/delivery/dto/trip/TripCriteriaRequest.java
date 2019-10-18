package oleksii.radyuk.delivery.dto.trip;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TripCriteriaRequest {
    private Long driverId;
    private Long carId;
    private Long trailerId;
    private Date date;
}
