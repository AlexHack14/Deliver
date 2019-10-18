package oleksii.radyuk.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
public class Trailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mark;
    private String model;
    private String VIN;
    private String carNumber;
    private int year;

    @OneToMany(mappedBy = "trailer")
    private List<Trip> tripList = new ArrayList<>();
}
