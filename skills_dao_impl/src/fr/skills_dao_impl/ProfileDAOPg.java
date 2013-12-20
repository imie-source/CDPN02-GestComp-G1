package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.ProfileDTO;

public class ProfileDAOPg implements DAO<ProfileDTO> {

	protected final String TABLE = "PROFILE";
	protected final String ID_PROFILE = "id_profile";
	protected final String NAME = "name";
	protected final String ID_PARENT = "id_parent";
	private final Connection connection;

	public ProfileDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public ProfileDTO create(ProfileDTO obj)
	{
		try
		{
			String SQL = "INSERT INTO " + TABLE + " (" + NAME + "," + ID_PARENT + ")" + "VALUES (?, ?)";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setString(1, obj.getName());
			prepStm.setInt(2, obj.getIdParent());
			prepStm.executeUpdate();
			Integer lastInsertId = null;
			ResultSet genKeys = prepStm.getGeneratedKeys();
			while (genKeys.next())
			{
				lastInsertId = genKeys.getInt(ID_PROFILE);
			}
			ProfileDTO new_obj = find(lastInsertId);
			prepStm.close();
			return new_obj;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(ProfileDTO obj)
	{
		boolean status = false;
		try
		{
			String SQL = "DELETE FROM " + TABLE + " WHERE " + ID_PROFILE + " = ?";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setInt(1, obj.getIdProfile());
			prepStm.close();
			status = true;
			return status;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return status;
		}
	}

	@Override
	public boolean update(ProfileDTO obj)
	{
		boolean status = false;
		try
		{
			String SQL = "UPDATE " + TABLE + " SET " + NAME + " = ?, " + ID_PARENT + " = ?)";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setString(1, obj.getName());
			prepStm.setInt(2, obj.getIdParent());
			int nb_updated = prepStm.executeUpdate(SQL);
			if (nb_updated > 0)
			{
				status = true;
			}
			prepStm.close();
			return status;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return status;
		}
	}

	@Override
	public ProfileDTO find(int id)
	{
		ProfileDTO obj = new ProfileDTO();
		try
		{
			String SQL = "SELECT " + NAME + ", " + ID_PARENT + " WHERE " + ID_PROFILE + " = ?";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setString(1, obj.getName());
			prepStm.setInt(2, obj.getIdParent());
			prepStm.setInt(3, obj.getIdProfile());
			ResultSet rs = prepStm.executeQuery();
			while (rs.next())
			{
				obj.setIdProfile(id);
				obj.setName(rs.getString(NAME));
				obj.setIdParent(rs.getInt(ID_PARENT));
			}
			return obj;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<ProfileDTO> findAll()
	{
		List<ProfileDTO> list = new ArrayList<ProfileDTO>();
		try
		{
			String SQL = "SELECT " + ID_PROFILE + ", " + NAME + ", " + ID_PARENT + " FROM " + TABLE;
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			ResultSet rs = prepStm.executeQuery();
			while (rs.next())
			{
				ProfileDTO obj = new ProfileDTO(rs.getInt(ID_PROFILE), rs.getInt(ID_PARENT), rs.getString(NAME));
				list.add(obj);
			}
			return list;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
