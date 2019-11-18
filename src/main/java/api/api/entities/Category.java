package api.api.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany (mappedBy = "category")
	private List<Recyclable> recyclable;

	protected Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public List<Recyclable> getRecyclable() {
		return recyclable;
	}
}
