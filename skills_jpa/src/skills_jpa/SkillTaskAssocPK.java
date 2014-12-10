package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the skill_task_assoc database table.
 * 
 */
@Embeddable
public class SkillTaskAssocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_task_task", insertable=false, updatable=false)
	private Integer idTaskTask;

	@Column(name="id_skill_skill", insertable=false, updatable=false)
	private Integer idSkillSkill;

	public SkillTaskAssocPK() {
	}
	public Integer getIdTaskTask() {
		return this.idTaskTask;
	}
	public void setIdTaskTask(Integer idTaskTask) {
		this.idTaskTask = idTaskTask;
	}
	public Integer getIdSkillSkill() {
		return this.idSkillSkill;
	}
	public void setIdSkillSkill(Integer idSkillSkill) {
		this.idSkillSkill = idSkillSkill;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SkillTaskAssocPK)) {
			return false;
		}
		SkillTaskAssocPK castOther = (SkillTaskAssocPK)other;
		return 
			this.idTaskTask.equals(castOther.idTaskTask)
			&& this.idSkillSkill.equals(castOther.idSkillSkill);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idTaskTask.hashCode();
		hash = hash * prime + this.idSkillSkill.hashCode();
		
		return hash;
	}
}