package oleksii.radyuk.delivery.repository;

import oleksii.radyuk.delivery.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findAllByNameLike(String name);
    List<Driver> findAllBySurnameLike(String surname);
}
