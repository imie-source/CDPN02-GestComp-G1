package fr.skills_service_impl;

import fr.skills_dao_int.DAO;
import fr.skills_dao_int.FactoryDAO;
import fr.skills_dto.NotificationDTO;
import fr.skills_service_int.INotificationService;

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
