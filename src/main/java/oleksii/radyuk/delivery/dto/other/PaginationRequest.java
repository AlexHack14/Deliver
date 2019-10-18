package oleksii.radyuk.delivery.dto.other;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PaginationRequest {
    private Sort.Direction direction = Sort.Direction.ASC;
    private String fieldName = "id";
    private Integer page = 0;
    private Integer size = 10;

    public Pageable toPageable() {
        return PageRequest.of(page, size, direction, fieldName);
    }
}
