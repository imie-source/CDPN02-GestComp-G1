package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_profile_assoc database table.
 * 
 */
@Entity
@Table(name="person_profile_assoc")
@NamedQuery(name="PersonProfileAssoc.findAll", query="SELECT p FROM PersonProfileAssoc p")
public class PersonProfileAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonProfileAssocPK id;

	public PersonProfileAssoc() {
	}

	public PersonProfileAssocPK getId() {
		return this.id;
	}

	public void setId(PersonProfileAssocPK id) {
		this.id = id;
	}

}