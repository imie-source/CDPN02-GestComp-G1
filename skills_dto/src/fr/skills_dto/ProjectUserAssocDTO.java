package fr.skills_dto;

public class ProjectUserAssocDTO {

/*****************************************VARIABLES***********************************************/
	private Integer idProject;
	private Integer idUser;
	
/****************************************CONSTRUCTORS*********************************************/	
	public ProjectUserAssocDTO(Integer idProject, Integer idUser) {
		super();
		this.idProject = idProject;
		this.idUser = idUser;
	}
	
	public ProjectUserAssocDTO() {
		super();
	}
	
/**************************************GETTERS/SETTERS********************************************/	
	public Integer getIdProject() {
		return idProject;
	}
	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
}
