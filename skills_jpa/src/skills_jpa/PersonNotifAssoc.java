package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_notif_assoc database table.
 * 
 */
@Entity
@Table(name="person_notif_assoc")
@NamedQuery(name="PersonNotifAssoc.findAll", query="SELECT p FROM PersonNotifAssoc p")
public class PersonNotifAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonNotifAssocPK id;

	public PersonNotifAssoc() {
	}

	public PersonNotifAssocPK getId() {
		return this.id;
	}

	public void setId(PersonNotifAssocPK id) {
		this.id = id;
	}

}