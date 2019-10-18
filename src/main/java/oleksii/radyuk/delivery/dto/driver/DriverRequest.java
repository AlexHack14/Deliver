package oleksii.radyuk.delivery.dto.driver;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DriverRequest {
    private String name;
    @NotNull
    private String surname;
}
