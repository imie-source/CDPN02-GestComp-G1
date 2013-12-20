package fr.skills.service.inter;

import java.util.List;

import fr.skills.dto.NotificationDTO;

public interface INotificationService {
	public NotificationDTO create(NotificationDTO aNotifDTO);

	public Boolean delete(NotificationDTO aNotifDTO);

	public Boolean update(NotificationDTO aNotifDTO);

	public NotificationDTO find(Integer anId);

	public List<NotificationDTO> findAll(Integer anId);

	public Boolean isOK(String anAction, final NotificationDTO aNotifDTO);
}
