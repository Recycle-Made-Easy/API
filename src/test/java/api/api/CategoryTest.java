package api.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import api.api.entities.Category;
import api.api.services.CategoryService;

public class CategoryTest {

	@Autowired 
	private CategoryService categoryService;
	
	@Test
	public void createAndSaveCategory() {
		Category category = new Category("Metals");
		categoryService.addCategory(category);
		Category savedCategory = categoryService.findCategoryByMaterial("Metals");
		assertEquals(category.getCategory(), "Metals");
	}
	
}
