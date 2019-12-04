package api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.Category;
import api.api.entities.RecycleCenter;
import api.api.repository.RecycleCenterRepository;

@Service
public class RecycleCenterService {
	
	@Autowired
	RecycleCenterRepository recycleCenterRepo;
	@Autowired
	CategoryService categoryService;
	@Autowired
	GeoLocationService geoLocationService;
	
	public RecycleCenter addRecycleCenter(RecycleCenter recycleLocation) {
		return recycleCenterRepo.save(recycleLocation);
	}

	public RecycleCenter findRecycleCenterByName(String name) {
		return recycleCenterRepo.findByName(name);
		
	}
	
	public List<RecycleCenter> findAllRecycleCenters() {
		return(List<RecycleCenter>) recycleCenterRepo.findAll();
	}

	public void deleteRecycleLocation(RecycleCenter recycleLocation) {
		recycleCenterRepo.delete(recycleLocation);
	}

	public void addRecycleLocation(String name) {
		RecycleCenter rl = new RecycleCenter(name);
		recycleCenterRepo.save(rl);
	}
		
	public void addCategoryToRecycleCenter(String centerName, String categoryName) {
		RecycleCenter rc = this.findRecycleCenterByName(centerName);
		Category category = categoryService.findCategoryByName(categoryName);
		rc.addCategory(category);
		recycleCenterRepo.save(rc);
	}
			
}
	
	


