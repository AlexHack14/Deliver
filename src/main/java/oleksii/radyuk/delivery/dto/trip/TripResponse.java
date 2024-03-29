package oleksii.radyuk.delivery.dto.trip;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import oleksii.radyuk.delivery.dto.car.CarResponse;
import oleksii.radyuk.delivery.dto.driver.DriverResponse;
import oleksii.radyuk.delivery.dto.trailer.TrailerResponse;

import java.time.LocalDate;


@Getter
@Setter
public class TripResponse {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double driverSalaryUa;
    private double driverSalaryEuro;
    private double driverSalaryZl;
    private double fuelBuy;
    private double fuelUse;
    private int amountDay;
    private double ukraineRange;
    private double europeRange;
    private String startDestination;
    private String endDestination;
    @JsonProperty("driver")
    private DriverResponse driverResponse;
    @JsonProperty("car")
    private CarResponse carResponse;
    @JsonProperty("trailer")
    private TrailerResponse trailerResponse;
}
