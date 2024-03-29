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
		return (List<RecycleCenter>) recycleCenterRepo.findAllByOrderByName();
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

	public void removeCategoryFromRecycleCenters(String categoryName) {
		Category category = categoryService.findCategoryByName(categoryName);
		List<RecycleCenter> allCenters = this.findAllRecycleCenters();
		for (RecycleCenter center : allCenters) {
			if (center.getCategories().contains(category)) {
				center.removeCategory(category);
				recycleCenterRepo.save(center);
			}
		}
	}

	public RecycleCenter saveChangesToRecycleCenter(RecycleCenter origRC, RecycleCenter updatedRC) {
		origRC.updateName(updatedRC.getName());
		origRC.updateStreetAddress(updatedRC.getStreetAddress());
		origRC.updateCity(updatedRC.getCity());
		origRC.updateState(updatedRC.getState());
		origRC.updateZipCode(updatedRC.getZipCode());
		origRC.updatePlaceId(updatedRC.getPlaceId());
		return recycleCenterRepo.save(origRC);
	}

	public RecycleCenter findRecycleCenterById(Long id) {
		return recycleCenterRepo.findById(id).get();
	}
}
