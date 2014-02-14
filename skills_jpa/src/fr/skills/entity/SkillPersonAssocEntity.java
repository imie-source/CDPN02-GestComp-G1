package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the skill_person_assoc database table.
 * 
 */
@Entity
@Table(name="skill_person_assoc")
public class SkillPersonAssocEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SkillPersonAssocEntityPK id;

	@Column(name="level_skill")
	private String levelSkill;

	//bi-directional many-to-one association to PersonEntity
	@ManyToOne
	@JoinColumn(name="id_person_person")
	private PersonEntity person;

	//bi-directional many-to-one association to SkillEntity
	@ManyToOne
	@JoinColumn(name="id_skill_skill")
	private SkillEntity skill;

	public SkillPersonAssocEntity() {
	}

	public SkillPersonAssocEntityPK getId() {
		return this.id;
	}

	public void setId(SkillPersonAssocEntityPK id) {
		this.id = id;
	}

	public String getLevelSkill() {
		return this.levelSkill;
	}

	public void setLevelSkill(String levelSkill) {
		this.levelSkill = levelSkill;
	}

	public PersonEntity getPerson() {
		return this.person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public SkillEntity getSkill() {
		return this.skill;
	}

	public void setSkill(SkillEntity skill) {
		this.skill = skill;
	}

}