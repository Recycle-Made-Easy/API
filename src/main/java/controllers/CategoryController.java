package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.Category;
import api.api.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> findAll() {
		return categoryService.findAllCategories();
	}

	@GetMapping("/{name}")
	public Category findCategoryByName(@PathVariable String name) {
		return categoryService.findCategoryByName(name);
	}
	
	@PostMapping("")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@DeleteMapping("/{name}/delete-category")
	public void deleteCategory(@PathVariable String name) {
		Category category = categoryService.findCategoryByName(name);
		categoryService.deleteCategory(category);
	}

}
