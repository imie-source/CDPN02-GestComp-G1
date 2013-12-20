package fr.skills.dto;

public class SkillTaskAssocDTO {
	/** VARIABLES ############################################################################## */
	private Integer id_task;
	private Integer id_skill;

    /** CONSTRUCTEURS ########################################################################## */
	public SkillTaskAssocDTO(Integer id_task, Integer id_skill) {
		this.id_task = id_task;
		this.id_skill = id_skill;
	}
	
	public SkillTaskAssocDTO() {}

	/** GETTERS & SETTERS ####################################################################### */
	public Integer getId_task() {
		return id_task;
	}

	public void setId_task(Integer id_task) {
		this.id_task = id_task;
	}

	public Integer getId_skill() {
		return id_skill;
	}

	public void setId_skill(Integer id_skill) {
		this.id_skill = id_skill;
	}
}
