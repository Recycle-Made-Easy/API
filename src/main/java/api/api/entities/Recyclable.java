package api.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recyclable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	private Category category;
	
	public Recyclable(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void updateName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}
	
	public void updateCategory(String name) {
		this.name = name;
	}
	

}
