package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.NotificationDTO;

public class NotificationDAOPg implements DAO<NotificationDTO> {

	private final Connection connection;

	public NotificationDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public NotificationDTO create(NotificationDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		Integer vId = 0;
		String req = "INSERT INTO notification (content, date) VALUES (?, ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
			stmtUpdate.setString(1, obj.getNotification());
			stmtUpdate.setDate(2, obj.getDateNotification());
			stmtUpdate.executeUpdate();
			ResultSet keyset = stmtUpdate.getGeneratedKeys();
			while (keyset.next())
			{
				vId = keyset.getInt(1);
			}
			obj.setIdNotification(vId);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean delete(NotificationDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		Integer vres = 0;
		String req = "DELETE FROM notification WHERE id_notification = ?";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getIdNotification());
			stmtUpdate.executeUpdate();
			vres = stmtUpdate.executeUpdate();
			if (vres != 0)
			{
				return true;
			} else
			{
				return false;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(NotificationDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		Integer vres = 0;
		String req = "UPDATE notification SET content = ?, date = ? WHERE id_notification = ?";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setString(1, obj.getNotification());
			stmtUpdate.setDate(2, obj.getDateNotification());
			stmtUpdate.setInt(3, obj.getIdNotification());
			stmtUpdate.executeUpdate();
			// stmtUpdate = connection.createStatement();
			vres = stmtUpdate.executeUpdate();
			if (vres != 0)
			{
				return true;
			} else
			{
				return false;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public NotificationDTO find(int id)
	{
		NotificationDTO myNotif = null;
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_notification, content, date FROM notification " + "WHERE id_notification = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				myNotif = new NotificationDTO(rs.getInt(1), rs.getString(2), rs.getDate(3));
			}
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		return myNotif;
	}

	@Override
	public List<NotificationDTO> findAll()
	{
		List<NotificationDTO> lstNotifs = new ArrayList<NotificationDTO>();
		Statement stmtQuery = null;
		ResultSet rs = null;
		try
		{
			stmtQuery = connection.createStatement();
			rs = stmtQuery.executeQuery("SELECT id_notification, content, date " + "FROM notification");
			while (rs.next())
			{
				NotificationDTO n = new NotificationDTO(rs.getInt(1), rs.getString(2), rs.getDate(3));
				lstNotifs.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstNotifs;
	}
}
