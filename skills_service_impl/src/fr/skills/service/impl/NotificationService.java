package fr.skills.service.impl;

import java.util.List;

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

	@Override
	public NotificationDTO create(NotificationDTO aNotifDTO)
	{
		if (isOK("create", aNotifDTO))
		{
			aNotifDTO = notifDAO.create(aNotifDTO);
		}
		return aNotifDTO;
	}

	@Override
	public Boolean delete(NotificationDTO aNotifDTO)
	{
		Boolean vRet = false;
		if (isOK("delete", aNotifDTO))
		{
			vRet = notifDAO.delete(aNotifDTO);
		}
		return vRet;
	}

	@Override
	public Boolean update(NotificationDTO aNotifDTO)
	{
		Boolean vRet = false;
		if (isOK("update", aNotifDTO))
		{
			notifDAO.update(aNotifDTO);
		}
		return vRet;
	}

	@Override
	public NotificationDTO find(Integer anId)
	{
		NotificationDTO vRet = null;
		if (anId != null)
		{
			vRet = notifDAO.find(anId);
		}
		return vRet;
	}

	@Override
	public List<NotificationDTO> findAll()
	{
		return notifDAO.findAll();
	}

	@Override
	public Boolean isOK(String anAction, final NotificationDTO aNotifDTO)
	{
		Boolean vRet = false;
		if (aNotifDTO != null)
		{
			switch (anAction.toLowerCase())
			{
			case "create":
				if ((aNotifDTO.getDateNotification() != null) && (aNotifDTO.getNotification() != null))
				{
					vRet = true;
				}
				break;
			case "delete":
				if (aNotifDTO.getIdNotification() != null)
				{
					vRet = true;
				}
				break;

			case "update":
				if ((aNotifDTO.getIdNotification() != null) && (aNotifDTO.getDateNotification() != null) && (aNotifDTO.getNotification() != null))
				{
					vRet = true;
				}
				break;
			default:
				break;
			}
		}
		return vRet;
	}

}
