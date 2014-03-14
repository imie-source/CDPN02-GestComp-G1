package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@Table(name="notification")
public class NotificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_notification")
	private Integer idNotification;

	private String content;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-many association to PersonEntity
	@ManyToMany(mappedBy="notifications")
	private List<PersonEntity> persons;

	//bi-directional many-to-one association to PersonNotifAssocEntity
	@OneToMany(mappedBy="notification")
	private List<PersonNotifAssocEntity> personNotifAssocs;

	public NotificationEntity() {
	}

	public Integer getIdNotification() {
		return this.idNotification;
	}

	public void setIdNotification(Integer idNotification) {
		this.idNotification = idNotification;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<PersonEntity> getPersons() {
		return this.persons;
	}

	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}

	public List<PersonNotifAssocEntity> getPersonNotifAssocs() {
		return this.personNotifAssocs;
	}

	public void setPersonNotifAssocs(List<PersonNotifAssocEntity> personNotifAssocs) {
		this.personNotifAssocs = personNotifAssocs;
	}

	public PersonNotifAssocEntity addPersonNotifAssoc(PersonNotifAssocEntity personNotifAssoc) {
		getPersonNotifAssocs().add(personNotifAssoc);
		personNotifAssoc.setNotification(this);

		return personNotifAssoc;
	}

	public PersonNotifAssocEntity removePersonNotifAssoc(PersonNotifAssocEntity personNotifAssoc) {
		getPersonNotifAssocs().remove(personNotifAssoc);
		personNotifAssoc.setNotification(null);

		return personNotifAssoc;
	}

}