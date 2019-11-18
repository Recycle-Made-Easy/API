package api.api.entities;

public class RecycleLocation {

	private Long id;
	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	protected RecycleLocation() {}
	
	public RecycleLocation(String name) {
		this.name = name;
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
	
	
	
	
}
