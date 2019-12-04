package api.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class RecycleCenter {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String placeId;
	@ManyToOne
	private GeoLocation geoLocation;
	@ManyToMany
	private List<Category> categories;

	protected RecycleCenter() {
	}

	public RecycleCenter(String name) {
		this.name = name;
		this.categories = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void updateName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void updateStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void updatePlaceId(String placeId) {
		this.placeId = placeId;
	}
	
	public String getPlaceId() {
		return this.placeId;
	}

	public String getCity() {
		return city;
	}

	public void updateCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void updateState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void updateZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}
	
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	
	public void updateGeoLocation(GeoLocation geo) {
		this.geoLocation = geo;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}
	
	public void removeCategory(Category category) {
		this.categories.remove(category);
	}

	@Override
	public String toString() {
		return "RecycleCenter [id=" + id + ", name=" + name + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", geoLocation=" + geoLocation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((geoLocation == null) ? 0 : geoLocation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		RecycleCenter other = (RecycleCenter) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (geoLocation == null) {
			if (other.geoLocation != null)
				return false;
		} else if (!geoLocation.equals(other.geoLocation))
			return false;
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
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	

}
