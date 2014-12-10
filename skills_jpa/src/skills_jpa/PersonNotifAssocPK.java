package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the person_notif_assoc database table.
 * 
 */
@Embeddable
public class PersonNotifAssocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_notification_notification", insertable=false, updatable=false)
	private Integer idNotificationNotification;

	@Column(name="id_person_person", insertable=false, updatable=false)
	private Integer idPersonPerson;

	public PersonNotifAssocPK() {
	}
	public Integer getIdNotificationNotification() {
		return this.idNotificationNotification;
	}
	public void setIdNotificationNotification(Integer idNotificationNotification) {
		this.idNotificationNotification = idNotificationNotification;
	}
	public Integer getIdPersonPerson() {
		return this.idPersonPerson;
	}
	public void setIdPersonPerson(Integer idPersonPerson) {
		this.idPersonPerson = idPersonPerson;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonNotifAssocPK)) {
			return false;
		}
		PersonNotifAssocPK castOther = (PersonNotifAssocPK)other;
		return 
			this.idNotificationNotification.equals(castOther.idNotificationNotification)
			&& this.idPersonPerson.equals(castOther.idPersonPerson);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idNotificationNotification.hashCode();
		hash = hash * prime + this.idPersonPerson.hashCode();
		
		return hash;
	}
}