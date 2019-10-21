package oleksii.radyuk.delivery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Trailer trailer;
}
