package api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.Category;
import api.api.entities.Recyclable;
import api.api.services.CategoryService;
import api.api.services.RecyclableService;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RecyclableService recyclableService;
	
	@GetMapping("/")
	public List<Category> findAll() {
		return categoryService.findAllCategories();
	}

	@GetMapping("/{name}")
	public Category findCategoryByName(@PathVariable String name) {
		return categoryService.findCategoryByName(name);
	}
	
	@PostMapping("/add/{name}/")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
		
	@PatchMapping("/{categoryName}/add/{recyclableName}")
	public void addRecyclableToCategory(@PathVariable String categoryName, @PathVariable String recyclableName) {
		Recyclable recyclable = new Recyclable(recyclableName);
		recyclableService.addRecyclable(recyclable);
		Category category = categoryService.findCategoryByName(categoryName);
		category.addRecyclable(recyclable);
		// 11/21/2019 10:38 a.m.: This method successfully brings the recyclable to existence but fails to add them to the Category's list of recyclables.
	}
	
	@PatchMapping("/{categoryName}/delete/{recyclableName}")
	public void removeSingleRecyclable(@PathVariable String categoryName, @PathVariable String recyclableName) {
		Recyclable recyclable = recyclableService.findRecyclableByName(recyclableName);
		Category category = categoryService.findCategoryByName(categoryName);
		category.removeRecyclable(recyclable);
		recyclableService.deleteRecyclable(recyclable);
	}
	
//	@DeleteMapping("/{name}/delete-category")
//	public void deleteCategory(@PathVariable String name) {
//		Category category = categoryService.findCategoryByName(name);
//		categoryService.deleteCategory(category);
//	}
	
}
