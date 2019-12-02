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
import api.api.entities.RecycleCenter;
import api.api.services.CategoryService;
import api.api.services.RecycleCenterService;

@CrossOrigin
@RestController
@RequestMapping("/api/centers")
public class RecycleCenterController {
	
	@Autowired
	private RecycleCenterService recycleLocationService; 
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<RecycleCenter> findAll() {
		return recycleLocationService.findAllRecycleLocations();
	}
	
	@GetMapping("/{name}")
	public RecycleCenter findRecyclableLocationByName(@PathVariable String name) {
		return recycleLocationService.findRecycleCenterByName(name);
	}
	
//	@GetMapping("/category/{categoryId}")
//	public Iterable<RecycleLocation> filterRecycleLocationsByCategory(@PathVariable Long categoryId) {
//		Category category = categoryService.findCategoryById(categoryId);
//		return recycleLocationService.findRecycleLocationsByCategory(category.getName());
//	}
	
	@PostMapping("")
	public RecycleCenter addRecycleLocation(@RequestBody RecycleCenter recycleLocation) {
		return recycleLocationService.addRecycleCenter(recycleLocation);
	}
	
	@DeleteMapping("/{name}/delete-category")
	public void deleteRecycleLocation(@PathVariable String name) {
		RecycleCenter recycleLocation = recycleLocationService.findRecycleCenterByName(name);
		recycleLocationService.deleteRecycleLocation(recycleLocation);
	}
	
	

}
