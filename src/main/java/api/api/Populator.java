package api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import api.api.entities.RecycleCenter;
import api.api.services.CategoryService;
import api.api.services.GeoLocationService;
import api.api.services.RecycleCenterService;

@Component
public class Populator implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RecycleCenterService recycleCenterService;

	@Autowired
	private GeoLocationService geoLocationService;

	@Override
	public void run(String... args) throws Exception {

		createGeoLocations();
		createCategories();
		createRecycleCenters();

	}
	
	private void createRecycleCenters() {		
		RecycleCenter rc1 = new RecycleCenter("Mark Gray Enterprises");
		rc1.updateStreetAddress("464 N Highland Ave");
		rc1.updateCity("Columbus");
		rc1.updateState("OH");
		rc1.updateZipCode("43204");
		rc1.updatePlaceId("ChIJX6FjmMaPOIgRB40RjiCNx6E");
		rc1.addCategory(categoryService.findCategoryByName("Metal"));
		recycleCenterService.addRecycleCenter(rc1);
		geoLocationService.addRecycleCenterToGeoLocation("Mark Gray Enterprises", "Valleyview");
		
		RecycleCenter rc2 = new RecycleCenter("Hugo Neu Recycling");
		rc2.updateStreetAddress("2801 Charter St");
		rc2.updateCity("Columbus");
		rc2.updateState("OH");
		rc2.updateZipCode("43228");
		rc2.updatePlaceId("ChIJEx0OZW6ROIgRp8fDhjF6k9k");
		rc2.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc2);
		geoLocationService.addRecycleCenterToGeoLocation("Hugo Neu Recycling", "Columbus");
	}	

	private void createCategories() {
		categoryService.addCategory("Metal");
		categoryService.addCategory("Glass");
		categoryService.addCategory("Construction Materials");
		categoryService.addCategory("Paper");
		categoryService.addCategory("Plastic");
		categoryService.addCategory("Electronics");
	}

	private void createGeoLocations() {
		geoLocationService.addGeoLocation("Dublin", "ChIJH6FQ1MTsOIgRKJBoFWgXwgA");
		geoLocationService.addGeoLocation("Clintonville", "ChIJn3LhCWiMOIgR3Rx6W6VV1PA");
		geoLocationService.addGeoLocation("Columbus", "ChIJcd6QucGJOIgRM7Wxz_hmMuQ");
		geoLocationService.addGeoLocation("Hilliard", "ChIJMxtWksaWOIgRnlXah9jo_aE");
		geoLocationService.addGeoLocation("Westerville", "ChIJVyNMY2X1OIgRQT9dsFQwoUY");
//		geoLocationService.addGeoLocation("Valleyview", "ChIJ59tJ7tuPOIgR3Mo25RT316g");
	}

}
