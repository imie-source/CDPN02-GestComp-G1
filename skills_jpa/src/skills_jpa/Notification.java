package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_notification")
	private Integer idNotification;

	private String content;

	@Temporal(TemporalType.DATE)
	private Date date;

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

}