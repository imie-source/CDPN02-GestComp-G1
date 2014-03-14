package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_notif_assoc database table.
 * 
 */
@Entity
@Table(name="person_notif_assoc")
public class PersonNotifAssocEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonNotifAssocEntityPK id;

	//bi-directional many-to-one association to NotificationEntity
	@ManyToOne
	@JoinColumn(name="id_notification_notification", updatable=false, insertable=false )
	private NotificationEntity notification;

	//bi-directional many-to-one association to PersonEntity
	@ManyToOne
	@JoinColumn(name="id_person_person", updatable=false, insertable=false )
	private PersonEntity person;

	public PersonNotifAssocEntity() {
	}

	public PersonNotifAssocEntityPK getId() {
		return this.id;
	}

	public void setId(PersonNotifAssocEntityPK id) {
		this.id = id;
	}

	public NotificationEntity getNotification() {
		return this.notification;
	}

	public void setNotification(NotificationEntity notification) {
		this.notification = notification;
	}

	public PersonEntity getPerson() {
		return this.person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

}