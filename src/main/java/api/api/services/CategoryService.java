package api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.Category;
import api.api.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
		
	}

	public Category findCategoryByName(String name) {
		return categoryRepo.findCategoryByName(name);
	}

	public List<Category> findAllCategories() {
		return (List<Category>) categoryRepo.findAll();
		
	}

	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
		
	}

}
