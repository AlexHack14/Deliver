package oleksii.radyuk.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor
@Getter
@Setter

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private double driverSalaryUa;
    private double driverSalaryEuro;
    private double driverSalaryZl;
    private double fuelBuy;
    private double fuelUse;
    private int amountDay;
    private double ukraineRange;
    private double europeRange;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Trailer trailer;
}
