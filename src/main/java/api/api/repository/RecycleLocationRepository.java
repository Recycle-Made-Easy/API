package api.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.api.RecycleLocation;

@Repository
public interface RecycleLocationRepository extends CrudRepository<RecycleLocation, Long> {

}
