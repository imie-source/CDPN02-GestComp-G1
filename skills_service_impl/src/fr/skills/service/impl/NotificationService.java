package fr.skills.service.impl;

import fr.skills.dao.inter.DAO;
import fr.skills.dao.inter.FactoryDAO;
import fr.skills.dto.NotificationDTO;
import fr.skills.service.inter.INotificationService;

public class NotificationService implements INotificationService {
	private final DAO<NotificationDTO> notifDAO;

	public NotificationService(FactoryDAO afdao)
	{
		notifDAO = afdao.getNotificationDAO();
	}

	public DAO<NotificationDTO> getNotifDAO()
	{
		return notifDAO;
	}

}
