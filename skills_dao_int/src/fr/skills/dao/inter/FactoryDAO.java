package fr.skills.dao.inter;

import fr.skills.dto.FonctionDTO;
import fr.skills.dto.NotificationDTO;
import fr.skills.dto.PermissionDTO;
import fr.skills.dto.ProfileDTO;
import fr.skills.dto.ProjectDTO;
import fr.skills.dto.TaskDTO;
import fr.skills.dto.UserDTO;

public interface FactoryDAO {

	public void beginTransaction();

	public void endTransaction();

	public DAO<TaskDTO> getTaskDAO();

	public DAO<FonctionDTO> getFonctionDAO();

	public DAO<PermissionDTO> getPermissionDAO();

	public RightsAssocDAO getRightsAssocDAO();

	public DAO<NotificationDTO> getNotificationDAO();

	public NotifAssocDAO getNotifAssocDAO();

	public DAO<ProfileDTO> getProfileDAO();

	public SkillTaskAssocDAO getSkillTaskAssocDAO();

	public PromotionUserAssocDAO getPromotionUserAssocDAO();

	public DAO<ProjectDTO> getProjectDAO();

	public DAO<UserDTO> getUserDAO();

}
