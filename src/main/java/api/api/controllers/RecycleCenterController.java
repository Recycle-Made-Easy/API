package api.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.RecycleCenter;
//import api.api.services.CategoryService;
import api.api.services.RecycleCenterService;

@CrossOrigin
@RestController
@RequestMapping("/api/centers")
public class RecycleCenterController {

	@Autowired
	private RecycleCenterService recycleCenterService;
//	@Autowired
//	private CategoryService categoryService;

	@GetMapping("")
	public List<RecycleCenter> findAll() {
		return recycleCenterService.findAllRecycleCenters();
	}

	@GetMapping("/{name}")
	public RecycleCenter findRecyclableLocationByName(@PathVariable String name) {
		return recycleCenterService.findRecycleCenterByName(name);
	}

	@GetMapping("/city/{city}")
	public List<RecycleCenter> findRecycleCentersByCity(@PathVariable String city) {
		List<RecycleCenter> allCenters = recycleCenterService.findAllRecycleCenters();
		List<RecycleCenter> filteredCenters = new ArrayList<>();

		for (RecycleCenter center : allCenters) {
			if (center.getCity().contains(city)) {
				filteredCenters.add(center);
			}
		}
		return filteredCenters;
	}

	@GetMapping("/cities")
	public List<String> findCities() {
		List<String> cities = new ArrayList<>();
		List<RecycleCenter> allCenters = recycleCenterService.findAllRecycleCenters();
		
		for (RecycleCenter center : allCenters) {
			if (!cities.contains(center.getCity())) {
				cities.add(center.getCity());
			}
		}
		return cities;
	}

//	@GetMapping("/category/{categoryId}")
//	public Iterable<RecycleLocation> filterRecycleLocationsByCategory(@PathVariable Long categoryId) {
//		Category category = categoryService.findCategoryById(categoryId);
//		return recycleLocationService.findRecycleLocationsByCategory(category.getName());
//	}

	@PostMapping("/add")
	public RecycleCenter addRecycleLocation(@RequestBody RecycleCenter recycleLocation) {
		return recycleCenterService.addRecycleCenter(recycleLocation);
	}

	@DeleteMapping("/{name}/delete-category")
	public void deleteRecycleLocation(@PathVariable String name) {
		RecycleCenter recycleLocation = recycleCenterService.findRecycleCenterByName(name);
		recycleCenterService.deleteRecycleLocation(recycleLocation);
	}

}
