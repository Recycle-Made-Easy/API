package api.api.services;

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
	
	public RecycleLocation findRecycleLocationByCity(String name) {
		return recycleLocationRepo.findRecycleLocationByName(name);
	}
	
	

}
