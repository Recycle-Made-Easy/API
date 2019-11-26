package api.api.controllers;

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

import api.api.entities.Category;
import api.api.entities.RecycleLocation;
import api.api.services.CategoryService;
import api.api.services.RecycleLocationService;

@CrossOrigin
@RestController
@RequestMapping("/api/recycle-locations")
public class RecyclableLocationController {
	
	@Autowired
	private RecycleLocationService recycleLocationService; 
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<RecycleLocation> findAll() {
		return recycleLocationService.findAllRecycleLocations();
	}
	
	@GetMapping("/{name}")
	public RecycleLocation findRecyclableLocationByName(@PathVariable String name) {
		return recycleLocationService.findRecycleLocationByName(name);
	}
	
//	@GetMapping("/category/{categoryId}")
//	public Iterable<RecycleLocation> filterRecycleLocationsByCategory(@PathVariable Long categoryId) {
//		Category category = categoryService.findCategoryById(categoryId);
//		return recycleLocationService.findRecycleLocationsByCategory(category.getName());
//	}
	
	@PostMapping("")
	public RecycleLocation addRecycleLocation(@RequestBody RecycleLocation recycleLocation) {
		return recycleLocationService.addRecycleLocation(recycleLocation);
	}
	
	@DeleteMapping("/{name}/delete-category")
	public void deleteRecycleLocation(@PathVariable String name) {
		RecycleLocation recycleLocation = recycleLocationService.findRecycleLocationByName(name);
		recycleLocationService.deleteRecycleLocation(recycleLocation);
	}
	
	

}
