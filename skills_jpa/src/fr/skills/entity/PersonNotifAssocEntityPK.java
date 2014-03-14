package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the person_notif_assoc database table.
 * 
 */
@Embeddable
public class PersonNotifAssocEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_notification_notification")
	private Integer idNotificationNotification;

	@Column(name="id_person_person")
	private Integer idPersonPerson;

	public PersonNotifAssocEntityPK() {
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
		if (!(other instanceof PersonNotifAssocEntityPK)) {
			return false;
		}
		PersonNotifAssocEntityPK castOther = (PersonNotifAssocEntityPK)other;
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