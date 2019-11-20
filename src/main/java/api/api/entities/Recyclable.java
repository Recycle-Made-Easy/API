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
	
	protected Recyclable() {}
	
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

	@Override
	public String toString() {
		return "Recyclable [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recyclable other = (Recyclable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	

}
