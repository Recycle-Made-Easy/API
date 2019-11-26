package api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.Category;
import api.api.entities.GeoLocation;
import api.api.repository.GeoLocationRepository;

@Service
public class GeoLocationService {

	@Autowired
	private GeoLocationRepository geoLocationRepo;
	@Autowired
	private CategoryService categoryService;
	
	public void addGeoLocation(String name, String placeId) {
		GeoLocation geoLocation = new GeoLocation(name, placeId);
		geoLocationRepo.save(geoLocation);
	}
	
	public List<GeoLocation> findAllGeoLocations(){
		return (List<GeoLocation>) geoLocationRepo.findAll();
	}
	
	public GeoLocation findGeoLocationById(Long id) {
		return geoLocationRepo.findById(id).get();
	}
	
	public List<Category> findCategoriesByGeoLocation(Long geoId){
		GeoLocation geo = this.findGeoLocationById(geoId);
		return geo.getCategories();
	}

	public GeoLocation findGeoLocationByName(String name) {
		return geoLocationRepo.findByName(name);	
	}
	
	public void addCategoryToGeoLocation(String geoLocationName, String categoryName) {
		GeoLocation geo = this.findGeoLocationByName(geoLocationName);
		Category category = categoryService.findCategoryByName(categoryName);
		geo.addCategory(category);
		geoLocationRepo.save(geo);
	}
}
