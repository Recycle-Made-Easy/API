package api.api.repository;

import org.springframework.data.repository.CrudRepository;
import api.api.entities.GeoLocation;

public interface GeoLocationRepository extends CrudRepository<GeoLocation, Long> {

	Iterable<GeoLocation> findAllByOrderByName();
	GeoLocation findByName(String name);
	GeoLocation findByPlaceId(String placeId);
}
