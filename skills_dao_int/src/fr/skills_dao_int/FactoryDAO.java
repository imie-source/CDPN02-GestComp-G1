package fr.skills_dao_int;

import fr.skills_dto.FonctionDTO;
import fr.skills_dto.NotificationDTO;
import fr.skills_dto.PermissionDTO;
import fr.skills_dto.ProfileDTO;
import fr.skills_dto.ProjectDTO;
import fr.skills_dto.TaskDTO;

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

}
