package oleksii.radyuk.delivery.repository;

import oleksii.radyuk.delivery.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long>, JpaSpecificationExecutor<Trip> {
}
