package fr.skills.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import fr.skills.dao.inter.DAO;
import fr.skills.dao.inter.FactoryDAO;
import fr.skills.dto.ProfileDTO;
import fr.skills.dto.UserDTO;

public class FactoryDAOPg implements FactoryDAO {

	private static Logger LOGGER = Logger.getLogger(FactoryDAOPg.class
			.getName());
	protected Connection connection;

	public FactoryDAOPg() {
		try {
			connection = ConnectionPool.getInstance().checkout();
		} catch (SQLException e) {
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
	}

	@Override
	public void beginTransaction() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}

	}

	@Override
	public void endTransaction() {
		try {
			connection.close();
		} catch (SQLException e) {
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
	}

	@Override
	public FonctionDAOPg getFonctionDAO() {
		return new FonctionDAOPg(connection);
	}

	@Override
	public PermissionDAOPg getPermissionDAO() {
		return new PermissionDAOPg(connection);
	}

	@Override
	public RightsAssocDAOPg getRightsAssocDAO() {
		return new RightsAssocDAOPg(connection);
	}

	@Override
	public NotificationDAOPg getNotificationDAO() {
		return new NotificationDAOPg(connection);
	}

	@Override
	public NotifAssocDAOPg getNotifAssocDAO() {
		return new NotifAssocDAOPg(connection);
	}

	@Override
	public SkillTaskAssocDAOPg getSkillTaskAssocDAO() {
		return new SkillTaskAssocDAOPg(connection);
	}

	@Override
	public PromotionUserAssocDAOPg getPromotionUserAssocDAO() {
		return new PromotionUserAssocDAOPg(connection);
	}

	@Override
	public TaskDAOPg getTaskDAO() {
		return new TaskDAOPg(connection);
	}

	@Override
	public ProjectDAOPg getProjectDAO() {
		return new ProjectDAOPg(connection);
	}

	@Override
	public DAO<ProfileDTO> getProfileDAO() {
		return new ProfileDAOPg(connection);
	}

	@Override
	public DAO<UserDTO> getUserDAO() {

		return new UserDAOPg(connection);
	}
}
