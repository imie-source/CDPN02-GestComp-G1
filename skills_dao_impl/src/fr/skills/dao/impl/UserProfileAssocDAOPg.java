package fr.skills.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.skills.dao.inter.DAO;
import fr.skills.dto.UserProfileAssocDTO;

public class UserProfileAssocDAOPg implements DAO<UserProfileAssocDTO> {
	protected final String TABLE = "PROFILE_ASSOC";
	protected final String ID_USER = "id_user";
	protected final String ID_PROFILE = "id_profile";

	private final Connection connection;

	public UserProfileAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public List<UserProfileAssocDTO> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfileAssocDTO create(UserProfileAssocDTO obj)
	{
		try
		{
			Statement stm = connection.createStatement();
			String SQL = "INSERT INTO " + TABLE + " (" + ID_USER + ", " + ID_PROFILE + ")" + "VALUES (" + obj.getIdUser() + ", " + obj.getIdProfile() + ")";
			stm.executeUpdate(SQL);
			stm.close();
			return obj;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(UserProfileAssocDTO obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserProfileAssocDTO obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserProfileAssocDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
