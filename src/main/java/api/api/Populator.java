package api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import api.api.entities.Category;
import api.api.entities.Recyclable;
import api.api.services.CategoryService;
import api.api.services.RecyclableService;

@Component
public class Populator implements CommandLineRunner {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RecyclableService recyclableService; 
	

	@Override
	public void run(String... args) throws Exception {
		
		Category materials1 = new Category("Metals");
		categoryService.addCategory(materials1);
		
		Category materials2 = new Category("Glass");
		categoryService.addCategory(materials2);
		
		Recyclable recyclable1 = new Recyclable("Pop Cans");
		recyclableService.addRecyclable(recyclable1);
		
		Recyclable recyclable2 = new Recyclable("Scrap Iron");
		recyclableService.addRecyclable(recyclable2);
	}
	

}
