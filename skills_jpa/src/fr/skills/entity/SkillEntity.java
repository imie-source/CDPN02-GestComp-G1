package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@Table(name="skill")
public class SkillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_skill")
	private Integer idSkill;

	@Column(name="name_skill")
	private String nameSkill;

	//bi-directional many-to-one association to SkillEntity
	@ManyToOne
	@JoinColumn(name="id_skill1")
	private SkillEntity skill;

	//bi-directional many-to-one association to SkillEntity
	@OneToMany(mappedBy="skill")
	private List<SkillEntity> skills;

	//bi-directional many-to-one association to SkillPersonAssocEntity
	@OneToMany(mappedBy="skill")
	private List<SkillPersonAssocEntity> skillPersonAssocs;

	//bi-directional many-to-many association to TaskEntity
	@ManyToMany(mappedBy="skills")
	private List<TaskEntity> tasks;

	public SkillEntity() {
	}

	public Integer getIdSkill() {
		return this.idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public String getNameSkill() {
		return this.nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}

	public SkillEntity getSkill() {
		return this.skill;
	}

	public void setSkill(SkillEntity skill) {
		this.skill = skill;
	}

	public List<SkillEntity> getSkills() {
		return this.skills;
	}

	public void setSkills(List<SkillEntity> skills) {
		this.skills = skills;
	}

	public SkillEntity addSkill(SkillEntity skill) {
		getSkills().add(skill);
		skill.setSkill(this);

		return skill;
	}

	public SkillEntity removeSkill(SkillEntity skill) {
		getSkills().remove(skill);
		skill.setSkill(null);

		return skill;
	}

	public List<SkillPersonAssocEntity> getSkillPersonAssocs() {
		return this.skillPersonAssocs;
	}

	public void setSkillPersonAssocs(List<SkillPersonAssocEntity> skillPersonAssocs) {
		this.skillPersonAssocs = skillPersonAssocs;
	}

	public SkillPersonAssocEntity addSkillPersonAssoc(SkillPersonAssocEntity skillPersonAssoc) {
		getSkillPersonAssocs().add(skillPersonAssoc);
		skillPersonAssoc.setSkill(this);

		return skillPersonAssoc;
	}

	public SkillPersonAssocEntity removeSkillPersonAssoc(SkillPersonAssocEntity skillPersonAssoc) {
		getSkillPersonAssocs().remove(skillPersonAssoc);
		skillPersonAssoc.setSkill(null);

		return skillPersonAssoc;
	}

	public List<TaskEntity> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

}