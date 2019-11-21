package api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.RecycleLocation;
import api.api.services.RecycleLocationService;

@RestController
@RequestMapping("/api/recycle-locations")
public class RecyclabelLocationController {
	
	@Autowired
	private RecycleLocationService recycleLocationService; 
	
	@GetMapping("")
	public List<RecycleLocation> findAll() {
		return recycleLocationService.findAllRecycleLocations();
	}
	
	@GetMapping("/{name}")
	public RecycleLocation findRecyclableLocationByName(@PathVariable String name) {
		return recycleLocationService.findRecycleLocationByName(name);
	}
	
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
