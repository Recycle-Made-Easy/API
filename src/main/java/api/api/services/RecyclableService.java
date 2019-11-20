package api.api.services;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.api.entities.Category;
import api.api.entities.Recyclable;
import api.api.repository.RecyclableRepository;

@Service
public class RecyclableService {

	@Autowired
	private RecyclableRepository recyclableRepo;
	
	public Recyclable addRecyclable(Recyclable recyclable) {
		return recyclableRepo.save(recyclable);
	}

	public Recyclable findRecyclableById(Long id) {
		Optional<Recyclable> recyclable = recyclableRepo.findById(id);
		return recyclableRepo.findById(id).get();
	}

	public void deleteRecyclable(Recyclable recyclable) {
		recyclableRepo.delete(recyclable);
	}

//	public void findRecyclableByName(String string) {
//	}

	public List<Recyclable> findAllRecyclables() {
		return (List<Recyclable>)recyclableRepo.findAll();
	}

}
