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

		RecycleCenter rc3 = new RecycleCenter("Ohio Drop Off");
		rc3.updateStreetAddress("533 N Nelson Rd");
		rc3.updateCity("Columbus");
		rc3.updateState("OH");
		rc3.updateZipCode("43219");
		rc3.updatePlaceId("ChIJRcAIzvuKOIgRSFyeJ0LI-7Y");
		rc3.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc3);
		geoLocationService.addRecycleCenterToGeoLocation("Ohio Drop Off", "Columbus");

		RecycleCenter rc4 = new RecycleCenter("Eco ATM");
		rc4.updateStreetAddress("60 Worthington Mall");
		rc4.updateCity("Worthington");
		rc4.updateState("OH");
		rc4.updateZipCode("43085");
		rc4.updatePlaceId("ChIJmeclb8PzOIgRzHlFCol8-E8");
		rc4.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc4);
		geoLocationService.addRecycleCenterToGeoLocation("Eco ATM", "Worthington");

		RecycleCenter rc5 = new RecycleCenter("Ohio Mulch Recycling");
		rc5.updateStreetAddress("4665 Westerville Road");
		rc5.updateCity("Westerville");
		rc5.updateState("OH");
		rc5.updateZipCode("43229");
		rc5.updatePlaceId("ChIJtXIJduyKOIgRguxb-Pk7F6k");
		rc5.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc5);
		geoLocationService.addRecycleCenterToGeoLocation("Ohio Mulch Recycling", "Westerville");

		RecycleCenter rc6 = new RecycleCenter("SWACO");
		rc6.updateStreetAddress("6007 Hoover Road");
		rc6.updateCity("Grove City");
		rc6.updateState("OH");
		rc6.updateZipCode("43123");
		rc6.updatePlaceId("ChIJtbrck0uDOIgRCY9talKIOmw");
		rc6.addCategory(categoryService.findCategoryByName("Glass"));
		rc6.addCategory(categoryService.findCategoryByName("Metal"));
		rc6.addCategory(categoryService.findCategoryByName("Plastic"));
		rc6.addCategory(categoryService.findCategoryByName("Paper"));
		recycleCenterService.addRecycleCenter(rc6);
		geoLocationService.addRecycleCenterToGeoLocation("SWACO", "Grove City");

		RecycleCenter rc7 = new RecycleCenter("Public Recycling");
		rc7.updateStreetAddress("Ramblebranch Dr");
		rc7.updateCity("Upper Arlington");
		rc7.updateState("OH");
		rc7.updateZipCode("43220");
		rc7.updatePlaceId("ChIJOZnWFniNOIgRnFFlLbDH_6M");
		rc7.addCategory(categoryService.findCategoryByName("Plastic"));
		rc7.addCategory(categoryService.findCategoryByName("Paper"));
		recycleCenterService.addRecycleCenter(rc7);
		geoLocationService.addRecycleCenterToGeoLocation("Public Recycling", "Upper Arlington");

		RecycleCenter rc8 = new RecycleCenter("Cyclemet");
		rc8.updateStreetAddress("2405 Harrison Road");
		rc8.updateCity("Columbus");
		rc8.updateState("OH");
		rc8.updateZipCode("43231");
		rc8.updatePlaceId("ChIJl8Vcb8-POIgRmGPiJCcteHQ");
		rc8.addCategory(categoryService.findCategoryByName("Metal"));
		recycleCenterService.addRecycleCenter(rc8);
		geoLocationService.addRecycleCenterToGeoLocation("Cyclemet", "Columbus");

		RecycleCenter rc9 = new RecycleCenter("Trader Joes");
		rc9.updateStreetAddress("6355 Sawmill Road");
		rc9.updateCity("Dublin");
		rc9.updateState("OH");
		rc9.updateZipCode("43017");
		rc9.updatePlaceId(
				"EiY2MzU1IFNhd21pbGwgUmQsIER1YmxpbiwgT0ggNDMwMTcsIFVTQSIxEi8KFAoSCZW7QbyxkjiIEUWRVhILwCSnENMxKhQKEgkTavbETe04iBESa8fS8_Ydhg");
		rc9.addCategory(categoryService.findCategoryByName("Plastic"));
		recycleCenterService.addRecycleCenter(rc9);
		geoLocationService.addRecycleCenterToGeoLocation("Trader Joes", "Dublin");

		RecycleCenter rc10 = new RecycleCenter("Best Buy");
		rc10.updateStreetAddress("1375 Polaris Pkwy");
		rc10.updateCity("Westerville");
		rc10.updateState("OH");
		rc10.updateZipCode("43240");
		rc10.updatePlaceId("ChIJzfgUKH30OIgRKamGvoX0Kkc");
		rc10.addCategory(categoryService.findCategoryByName("Electronics"));
		recycleCenterService.addRecycleCenter(rc10);
		geoLocationService.addRecycleCenterToGeoLocation("Best Buy", "Westerville");

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
		geoLocationService.addGeoLocation("Worthington", "ChIJNbdtieWKOIgRcQESDx-_8Jk");

	}

}
