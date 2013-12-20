package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.NotifAssocDAO;
import fr.skills_dto.NotifAssocDTO;

public class NotifAssocDAOPg implements NotifAssocDAO {

	private final Connection connection;

	public NotifAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public NotifAssocDTO create(NotifAssocDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		String req = "INSERT INTO notif_assoc (id_notification, id_user) VALUES (?, ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getIdNotification());
			stmtUpdate.setInt(2, obj.getIdUser());
			stmtUpdate.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean delete(NotifAssocDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		Integer vres = 0;
		String req = "DELETE FROM notif_assoc WHERE id_notification = ? AND id_user = ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getIdNotification());
			stmtUpdate.setInt(2, obj.getIdUser());
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
	public boolean update(NotifAssocDTO obj)
	{
		// Pas d'update pour cette table.
		return false;
	}

	@Override
	public NotifAssocDTO find(int id)
	{
		// Pas de get par un Id pour cette table.
		return null;
	}

	@Override
	public List<NotifAssocDTO> findbyUser(Integer id)
	{
		List<NotifAssocDTO> lstNotifs = new ArrayList<NotifAssocDTO>();
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_notification, id_user FROM notif_assoc WHERE id_user = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				NotifAssocDTO n = new NotifAssocDTO(rs.getInt(1), rs.getInt(2));
				lstNotifs.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstNotifs;
	}

	@Override
	public List<NotifAssocDTO> findbyNotif(Integer id)
	{
		List<NotifAssocDTO> lstNotifs = new ArrayList<NotifAssocDTO>();
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_notification, id_user FROM notif_assoc WHERE id_notification = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				NotifAssocDTO n = new NotifAssocDTO(rs.getInt(1), rs.getInt(2));
				lstNotifs.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstNotifs;
	}

	@Override
	public List<NotifAssocDTO> findAll()
	{
		List<NotifAssocDTO> lstNotifs = new ArrayList<NotifAssocDTO>();
		Statement stmtQuery = null;
		ResultSet rs = null;
		try
		{
			stmtQuery = connection.createStatement();
			rs = stmtQuery.executeQuery("SELECT id_notification, id_user " + "FROM notif_assoc");
			while (rs.next())
			{
				NotifAssocDTO n = new NotifAssocDTO(rs.getInt(1), rs.getInt(2));
				lstNotifs.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstNotifs;
	}

}
