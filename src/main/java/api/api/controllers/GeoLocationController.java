package api.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.Category;
import api.api.entities.GeoLocation;
import api.api.entities.RecycleCenter;
import api.api.services.CategoryService;
import api.api.services.GeoLocationService;

@CrossOrigin
@RestController
@RequestMapping("/api/geo")
public class GeoLocationController {

	@Autowired
	private GeoLocationService geoLocationService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public List<GeoLocation> findAllGeoLocations() {
		return geoLocationService.findAllGeoLocations();
	}

	@GetMapping("/{geoId}")
	public List<RecycleCenter> findRecycleCentersByGeoLocationId(@PathVariable Long geoId) {
		GeoLocation geo = geoLocationService.findGeoLocationById(geoId);
		return geo.getRecycleCenters();
	}

	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/{geoId}/{catId}")
	public List<RecycleCenter> findCentersByLocationAndCat(@PathVariable Long geoId,
		@PathVariable Long catId) {
		Category filteredCat = categoryService.findCategoryById(catId);
		return geoLocationService.findGeoLocationById(geoId)
								 .getRecycleCenters()
								 .stream()
								 .filter(center -> center.getCategories().equals(filteredCat))
								 .collect(Collectors.toList());

	
	}
	

}
