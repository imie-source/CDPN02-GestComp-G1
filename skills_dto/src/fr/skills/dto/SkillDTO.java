package fr.skills.dto;

public class SkillDTO {
	
/*****************************************VARIABLES***********************************************/
	private Integer id;
	private String name;

/****************************************CONSTRUCTORS*********************************************/	
	public SkillDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public SkillDTO() {
		super();
	}
	
/**************************************GETTERS/SETTERS********************************************/	
	public int getId() {
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
	
}
