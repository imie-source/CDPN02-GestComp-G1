package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the skill_task_assoc database table.
 * 
 */
@Entity
@Table(name="skill_task_assoc")
@NamedQuery(name="SkillTaskAssoc.findAll", query="SELECT s FROM SkillTaskAssoc s")
public class SkillTaskAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SkillTaskAssocPK id;

	public SkillTaskAssoc() {
	}

	public SkillTaskAssocPK getId() {
		return this.id;
	}

	public void setId(SkillTaskAssocPK id) {
		this.id = id;
	}

}