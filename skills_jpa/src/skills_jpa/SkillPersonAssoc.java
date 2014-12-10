package skills_jpa;

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

	@Column(name="level_skill")
	private String levelSkill;

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

}