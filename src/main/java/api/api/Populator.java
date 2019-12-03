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
		
		RecycleCenter rc3 = new RecycleCenter("Ohio Drop Off Recycling Center");
		rc3.updateStreetAddress("533 N Nelson Rd");
		rc3.updateCity("Columbus");
		rc3.updateState("OH");
		rc3.updateZipCode("43219");
		rc3.updatePlaceId("ChIJRcAIzvuKOIgRSFyeJ0LI-7Y");
		rc3.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc3);
		geoLocationService.addRecycleCenterToGeoLocation("Ohio Drop Off Recycling Center", "Columbus");
		
		RecycleCenter rc4 = new RecycleCenter("Eco ATM");
		rc4.updateStreetAddress("60 Worthington Mall");
		rc4.updateCity("Worthington");
		rc4.updateState("OH");
		rc4.updateZipCode("43085");
		rc4.updatePlaceId("ChIJmeclb8PzOIgRzHlFCol8-E8");
		rc4.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc4);
		geoLocationService.addRecycleCenterToGeoLocation("Eco ATM", "Worthington");
		
		RecycleCenter rc5 = new RecycleCenter("Ohio Mulch Recycling Drop Off");
		rc5.updateStreetAddress("4665 Westerville Road");
		rc5.updateCity("Westerville");
		rc5.updateState("OH");
		rc5.updateZipCode("43229");
		rc5.updatePlaceId("ChIJtXIJduyKOIgRguxb-Pk7F6k");
		rc5.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc5);
		geoLocationService.addRecycleCenterToGeoLocation("Eco ATM", "Worthington");
		

		
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
		geoLocationService.addGeoLocation("Clintonville", "ChIJn3LhCWiMOIgR3Rx6W6VV1PA");
		geoLocationService.addGeoLocation("Columbus", "ChIJcd6QucGJOIgRM7Wxz_hmMuQ");
		geoLocationService.addGeoLocation("Dublin", "ChIJH6FQ1MTsOIgRKJBoFWgXwgA");
		geoLocationService.addGeoLocation("Hilliard", "ChIJMxtWksaWOIgRnlXah9jo_aE");


		geoLocationService.addGeoLocation("Valleyview", "ChIJ59tJ7tuPOIgR3Mo25RT316g");
		geoLocationService.addGeoLocation("Lewis Center", "ChIJI688xEDxOIgRLNqjrf7ByUQ");
		geoLocationService.addGeoLocation("Westerville", "ChIJVyNMY2X1OIgRQT9dsFQwoUY");
		geoLocationService.addGeoLocation("Worthington","ChIJNbdtieWKOIgRcQESDx-_8Jk");

	}

}
