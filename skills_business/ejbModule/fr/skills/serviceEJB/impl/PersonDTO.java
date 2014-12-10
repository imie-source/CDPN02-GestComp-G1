package fr.skills.serviceEJB.impl;

public class PersonDTO {
	Integer id;
	String name,description;
	Boolean status;

	public PersonDTO(Integer id, String name, String description, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
