package api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.Category;
import api.api.entities.GeoLocation;
import api.api.services.GeoLocationService;

@CrossOrigin
@RestController
@RequestMapping("/api/geo")
public class GeoLocationController {

	@Autowired
	private GeoLocationService geoLocationService;
	
	@GetMapping("/")
	public List<GeoLocation> findAllGeoLocations(){
		return geoLocationService.findAllGeoLocations();
	}
	
	@GetMapping("/{geoId}")
	public List<Category> findCategoriesByGeoLocationId(@PathVariable Long geoId) {
		return geoLocationService.findCategoriesByGeoLocation(geoId);
	}
	
}
