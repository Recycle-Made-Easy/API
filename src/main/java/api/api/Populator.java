package api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import api.api.entities.Category;
import api.api.services.CategoryService;

@Component
public class Populator implements CommandLineRunner {
	
	@Autowired
	private CategoryService categoryService;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category materials1 = new Category("Metals");
		
		categoryService.addCategory(materials1);
		
	}
	

}
