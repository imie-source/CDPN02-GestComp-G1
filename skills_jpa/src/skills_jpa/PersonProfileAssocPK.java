package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the person_profile_assoc database table.
 * 
 */
@Embeddable
public class PersonProfileAssocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_person_person", insertable=false, updatable=false)
	private Integer idPersonPerson;

	@Column(name="id_profile_profile", insertable=false, updatable=false)
	private Integer idProfileProfile;

	public PersonProfileAssocPK() {
	}
	public Integer getIdPersonPerson() {
		return this.idPersonPerson;
	}
	public void setIdPersonPerson(Integer idPersonPerson) {
		this.idPersonPerson = idPersonPerson;
	}
	public Integer getIdProfileProfile() {
		return this.idProfileProfile;
	}
	public void setIdProfileProfile(Integer idProfileProfile) {
		this.idProfileProfile = idProfileProfile;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonProfileAssocPK)) {
			return false;
		}
		PersonProfileAssocPK castOther = (PersonProfileAssocPK)other;
		return 
			this.idPersonPerson.equals(castOther.idPersonPerson)
			&& this.idProfileProfile.equals(castOther.idProfileProfile);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersonPerson.hashCode();
		hash = hash * prime + this.idProfileProfile.hashCode();
		
		return hash;
	}
}