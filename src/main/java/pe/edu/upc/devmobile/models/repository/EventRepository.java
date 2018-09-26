package pe.edu.upc.devmobile.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
}
