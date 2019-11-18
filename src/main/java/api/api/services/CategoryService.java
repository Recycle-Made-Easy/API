package api.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.Category;
import api.api.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	
	public Category addCategory(Category category) {
		Category savedCategory = categoryRepo.save(category);
		return savedCategory;
		
	}

	public Category findCategoryByMaterial(String string) {
		return null;
	}

}
