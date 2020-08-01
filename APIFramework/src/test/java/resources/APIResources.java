package resources;



//Enum is special class of class and its collection of contact and methods
public enum APIResources {

	
	
	AddEmp("/api/v1/create"),
	GetEmp("/api/v1/employee/"),
	DeleteEmp("/api/v1/delete/");
	
	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getresource() {
		return resource;
	}
}
