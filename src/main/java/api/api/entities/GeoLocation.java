package api.api.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GeoLocation {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String placeId;
	@OneToMany(mappedBy = "geoLocation")
	private List<RecycleCenter> recycleCenters;
	
	protected GeoLocation() {}
	
	public GeoLocation(String name, String placeId) {
		this.name = name;
		this.placeId = placeId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getPlaceId() {
		return placeId;
	}
	
	public List<RecycleCenter> getRecycleCenters() {
		return this.recycleCenters;
	}
	
	public void addRecycleCenterToGeoLocation(RecycleCenter rc) {
		this.recycleCenters.add(rc);
	}

	@Override
	public String toString() {
		return "GeoLocation [id=" + id + ", name=" + name + ", placeId=" + placeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((placeId == null) ? 0 : placeId.hashCode());
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
		GeoLocation other = (GeoLocation) obj;
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
		if (placeId == null) {
			if (other.placeId != null)
				return false;
		} else if (!placeId.equals(other.placeId))
			return false;
		return true;
	}

	

	
	
	
	
}
