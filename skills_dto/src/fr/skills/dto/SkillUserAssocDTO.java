package fr.skills.dto;

public class SkillUserAssocDTO {
	
/*****************************************VARIABLES***********************************************/
	private Integer idUser;
	private Integer idSkill;
	private Integer levelSkill;

/****************************************CONSTRUCTORS*********************************************/	
	public SkillUserAssocDTO(Integer idUser, Integer idSkill, Integer levelSkill) {
		super();
		this.idUser = idUser;
		this.idSkill = idSkill;
		this.levelSkill = levelSkill;
	}

	public SkillUserAssocDTO() {
		super();
	}

/**************************************GETTERS/SETTERS********************************************/	

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public Integer getLevelSkill() {
		return levelSkill;
	}

	public void setLevelSkill(Integer levelSkill) {
		this.levelSkill = levelSkill;
	}
	
}
