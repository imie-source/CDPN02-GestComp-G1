package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the skill_person_assoc database table.
 * 
 */
@Embeddable
public class SkillPersonAssocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_person_person", insertable=false, updatable=false)
	private Integer idPersonPerson;

	@Column(name="id_skill_skill", insertable=false, updatable=false)
	private Integer idSkillSkill;

	public SkillPersonAssocPK() {
	}
	public Integer getIdPersonPerson() {
		return this.idPersonPerson;
	}
	public void setIdPersonPerson(Integer idPersonPerson) {
		this.idPersonPerson = idPersonPerson;
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
		if (!(other instanceof SkillPersonAssocPK)) {
			return false;
		}
		SkillPersonAssocPK castOther = (SkillPersonAssocPK)other;
		return 
			this.idPersonPerson.equals(castOther.idPersonPerson)
			&& this.idSkillSkill.equals(castOther.idSkillSkill);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersonPerson.hashCode();
		hash = hash * prime + this.idSkillSkill.hashCode();
		
		return hash;
	}
}