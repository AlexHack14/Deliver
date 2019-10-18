package oleksii.radyuk.delivery.repository;

import oleksii.radyuk.delivery.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByMarkLike(String mark);
    List<Car> findAllByCarNumberLike(String carNumber);

}
