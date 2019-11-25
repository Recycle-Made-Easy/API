package api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import api.api.entities.Category;
import api.api.entities.Recyclable;
import api.api.entities.RecycleLocation;
import api.api.services.CategoryService;
import api.api.services.RecyclableService;
import api.api.services.RecycleLocationService;

@Component
public class Populator implements CommandLineRunner {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RecyclableService recyclableService; 
	
	@Autowired
	private RecycleLocationService recycleLocationService;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category metals = new Category("Metals");
		categoryService.addCategory(metals);
		
		Category glass = new Category("Glass");
		categoryService.addCategory(glass);
		
		Recyclable recyclable1 = new Recyclable("Pop Cans");
		recyclableService.addRecyclable(recyclable1);
		
		Recyclable recyclable2 = new Recyclable("Scrap Iron");
		recyclableService.addRecyclable(recyclable2);
		
		RecycleLocation location1 = new RecycleLocation("Mark Gray Enterprises");
		recycleLocationService.addRecycleLocation(location1);
		recycleLocationService.addCategoryToLocation(location1, metals);
		
		RecycleLocation location2 = new RecycleLocation("Hugo Neu Recycling");
		recycleLocationService.addRecycleLocation(location2);
		recycleLocationService.addCategoryToLocation(location2, metals);
		recycleLocationService.addCategoryToLocation(location2, glass);
	}
	

}
