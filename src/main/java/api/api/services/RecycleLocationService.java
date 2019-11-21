package api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.RecycleLocation;
import api.api.repository.RecycleLocationRepository;

@Service
public class RecycleLocationService {
	@Autowired
	RecycleLocationRepository recycleLocationRepo;
	
	public RecycleLocation addRecycleLocation(RecycleLocation recycleLocation) {
		return recycleLocationRepo.save(recycleLocation);
	}

	public RecycleLocation findRecycleLocationByName(String name) {
		return recycleLocationRepo.findRecycleLocationByName(name);
		
	}
	
	public List<RecycleLocation> findAllRecycleLocations() {
		return(List<RecycleLocation>) recycleLocationRepo.findAll();
	}

	public void deleteRecycleLocation(RecycleLocation recycleLocation) {
		recycleLocationRepo.delete(recycleLocation);
		
	}
		
		
}
	
	


