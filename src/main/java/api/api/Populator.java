package api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import api.api.services.CategoryService;
import api.api.services.GeoLocationService;
import api.api.services.RecycleLocationService;

@Component
public class Populator implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RecycleLocationService recycleLocationService;

	@Autowired
	private GeoLocationService geoLocationService;

	@Override
	public void run(String... args) throws Exception {

		geoLocations();
		categories();
		recycleLocations();
		
		addCategoriesToGeoLocations();
		addRecycleLocationsToCategories();

	}

	private void addRecycleLocationsToCategories() {
		categoryService.addRecycleLocationToCategory("Mark Gray Enterprises","Metal");
		categoryService.addRecycleLocationToCategory("Hugo Neu Recycling","Glass");
		categoryService.addRecycleLocationToCategory("Hugo Neu Recycling","Metal");
	}

	private void addCategoriesToGeoLocations() {
		geoLocationService.addCategoryToGeoLocation("Dublin", "Metal");
		geoLocationService.addCategoryToGeoLocation("Dublin", "Glass");
		geoLocationService.addCategoryToGeoLocation("Dublin", "Paper");
		geoLocationService.addCategoryToGeoLocation("Hilliard", "Metal");
		geoLocationService.addCategoryToGeoLocation("Hilliard", "Glass");
		geoLocationService.addCategoryToGeoLocation("Westerville", "Construction");
		geoLocationService.addCategoryToGeoLocation("Westerville", "Paper");
		geoLocationService.addCategoryToGeoLocation("Clintonville", "Plastic");
	}

	private void recycleLocations() {
		recycleLocationService.addRecycleLocation("Mark Gray Enterprises");
		recycleLocationService.addRecycleLocation("Hugo Neu Recycling");
	}

	private void categories() {
		categoryService.addCategory("Metal");
		categoryService.addCategory("Glass");
		categoryService.addCategory("Construction");
		categoryService.addCategory("Paper");
		categoryService.addCategory("Plastic");
	}

	private void geoLocations() {
		geoLocationService.addGeoLocation("Dublin", "ChIJH6FQ1MTsOIgRKJBoFWgXwgA");
		geoLocationService.addGeoLocation("Clintonville", "ChIJn3LhCWiMOIgR3Rx6W6VV1PA");
		geoLocationService.addGeoLocation("Columbus", "ChIJcd6QucGJOIgRM7Wxz_hmMuQ");
		geoLocationService.addGeoLocation("Hilliard", "ChIJMxtWksaWOIgRnlXah9jo_aE");
		geoLocationService.addGeoLocation("Westerville", "ChIJVyNMY2X1OIgRQT9dsFQwoUY");
	}

}
