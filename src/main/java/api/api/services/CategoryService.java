package api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.Category;
import api.api.entities.RecycleCenter;
import api.api.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	RecycleCenterService recycleCenterService;
	@Autowired
	CategoryService categoryService;

	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	public void addCategory(String name) {
		Category category = new Category(name);
		categoryRepo.save(category);
	}

	public Category findCategoryByName(String name) {
		return categoryRepo.findCategoryByName(name);
	}

	public Category findCategoryById(Long id) {
		return categoryRepo.findById(id).get();
	}

	public List<Category> findAllCategories() {
		return (List<Category>) categoryRepo.findAll();

	}

	public void deleteCategory(String name) {
		Category category = categoryRepo.findCategoryByName(name);
		recycleCenterService.removeCategoryFromRecycleCenters(name);
		categoryRepo.delete(category);
	}

	public void addRecycleLocationToCategory(String recycleLocationName, String categoryName) {
		RecycleCenter recycleLocation = recycleCenterService.findRecycleCenterByName(recycleLocationName);
		Category category = categoryService.findCategoryByName(categoryName);
		category.addRecycleLocation(recycleLocation);
		categoryRepo.save(category);
	}

}
