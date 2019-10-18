package oleksii.radyuk.delivery.repository;

import oleksii.radyuk.delivery.entity.Car;
import oleksii.radyuk.delivery.entity.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer,Long> {
    List<Car> findAllByMarkLike(String mark);
    List<Car> findAllByCarNumberLike(String carNumber);
}
