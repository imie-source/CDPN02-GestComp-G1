package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the skill_person_assoc database table.
 * 
 */
@Entity
@Table(name="skill_person_assoc")
@NamedQuery(name="SkillPersonAssoc.findAll", query="SELECT s FROM SkillPersonAssoc s")
public class SkillPersonAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SkillPersonAssocPK id;

	@Column(name="level_skill", length=25)
	private String levelSkill;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_person_person", nullable=false, insertable=false, updatable=false)
	private Person person;

	//bi-directional many-to-one association to Skill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_skill_skill", nullable=false, insertable=false, updatable=false)
	private Skill skill;

	public SkillPersonAssoc() {
	}

	public SkillPersonAssocPK getId() {
		return this.id;
	}

	public void setId(SkillPersonAssocPK id) {
		this.id = id;
	}

	public String getLevelSkill() {
		return this.levelSkill;
	}

	public void setLevelSkill(String levelSkill) {
		this.levelSkill = levelSkill;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}