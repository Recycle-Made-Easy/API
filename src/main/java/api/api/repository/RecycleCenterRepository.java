package api.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.api.entities.RecycleCenter;

@Repository
public interface RecycleCenterRepository extends CrudRepository<RecycleCenter, Long> {

	RecycleCenter findByName(String name);
	
}
