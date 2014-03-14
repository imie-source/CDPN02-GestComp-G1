package fr.skills.dto;

import java.sql.Date;

public class NotificationDTO {

	private Integer idNotification;
	private String notification;
	private Date dateNotification;

	public NotificationDTO(Integer idNotification, String notification,
			Date dateNotification) {
		setIdNotification(idNotification);
		setNotification(notification);
		setDateNotification(dateNotification);
	}

	public NotificationDTO() {
	}

	public Integer getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Integer idNotification) {
		this.idNotification = idNotification;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Date getDateNotification() {
		return dateNotification;
	}

	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}

}
