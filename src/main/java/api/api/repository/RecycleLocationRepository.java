package api.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.api.entities.RecycleLocation;

@Repository
public interface RecycleLocationRepository extends CrudRepository<RecycleLocation, Long> {

}
