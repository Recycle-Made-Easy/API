package api.api;

public class Recyclable {

	private Long id;
	private String name;
	
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
	
	

}
