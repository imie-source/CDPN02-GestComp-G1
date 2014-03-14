package fr.skills.dto;

public class ProjectLeaderDTO {

/*****************************************VARIABLES***********************************************/
	private Integer idUser;
	private Integer idProject;

/****************************************CONSTRUCTORS*********************************************/	
	public ProjectLeaderDTO(Integer idUser, Integer idProject) {
		super();
		this.idUser = idUser;
		this.idProject = idProject;
	}

	public ProjectLeaderDTO() {
		super();
	}

/**************************************GETTERS/SETTERS********************************************/	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdProject() {
		return idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}
	
	
}
