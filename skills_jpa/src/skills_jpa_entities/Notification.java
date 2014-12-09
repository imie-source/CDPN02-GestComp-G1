package skills_jpa_entities;

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
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_notification", unique=true, nullable=false)
	private Integer idNotification;

	@Column(nullable=false, length=2000)
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	//bi-directional many-to-many association to Person
	@ManyToMany(mappedBy="notifications")
	private List<Person> persons;

	public Notification() {
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

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}