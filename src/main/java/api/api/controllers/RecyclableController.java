package api.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.api.entities.Recyclable;
import api.api.services.RecyclableService;

@RestController
@RequestMapping("/api/recyclables")
public class RecyclableController {

	@Autowired
	private RecyclableService recyclableService;
	
	@GetMapping("/")
	public List<Recyclable> getAllRecyclables(){
		return recyclableService.findAllRecyclables();
	}
	
	@GetMapping("/{id}")
	public Recyclable getSingleRecyclable(@PathVariable Long id) {
		return recyclableService.findRecyclableById(id);
	}
	
}






