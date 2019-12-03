package api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.GeoLocation;
import api.api.entities.RecycleCenter;
import api.api.repository.GeoLocationRepository;

@Service
public class GeoLocationService {

	@Autowired
	private GeoLocationRepository geoLocationRepo;
	@Autowired
	private RecycleCenterService recycleCenterService;
	
	public void addGeoLocation(String name, String placeId) {
		GeoLocation geoLocation = new GeoLocation(name, placeId);
		geoLocationRepo.save(geoLocation);
	}
	
	public List<GeoLocation> findAllGeoLocations(){
		return (List<GeoLocation>) geoLocationRepo.findAllByOrderByName();
	}
	
	public GeoLocation findGeoLocationById(Long id) {
		return geoLocationRepo.findById(id).get();
	}
	
	public GeoLocation findGeoLocationByName(String name) {
		return geoLocationRepo.findByName(name);	
	}
	
	public GeoLocation findGeoLocationByPlaceId(String placeId) {
		return geoLocationRepo.findByPlaceId(placeId);
	}
	
	public void addRecycleCenterToGeoLocation(String recycleCenterName, String geoLocationName) {
		RecycleCenter rc = recycleCenterService.findRecycleCenterByName(recycleCenterName);
		GeoLocation gl = this.findGeoLocationByName(geoLocationName);
		rc.updateGeoLocation(gl);
		recycleCenterService.addRecycleCenter(rc);	
//		gl.addRecycleCenterToGeoLocation(rc);
//		geoLocationRepo.save(gl);
	}
}
