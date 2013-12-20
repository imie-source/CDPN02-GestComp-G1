package fr.skills.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills.dao.inter.DAO;
import fr.skills.dto.UserDTO;

public class UserDAOPg implements DAO<UserDTO> {
	protected final String TABLE = "USER";
	protected final String ID_USER = "id_user";
	protected final String NAME = "name";
	protected final String LOGIN = "login";
	protected final String PASSWORD = "password";
	protected final String EMAIL = "email";
	protected final String PHONE = "phone";
	protected final String DESCRIPTION = "description";
	protected final String AVAILABLE = "available";

	private final Connection connection;

	public UserDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public UserDTO create(UserDTO obj)
	{
		try
		{
			String SQL = "INSERT INTO " + TABLE + " (" + NAME + "," + LOGIN + ", " + PASSWORD + ", " + EMAIL + ", " + PHONE + ", " + DESCRIPTION + ", " + AVAILABLE + ")"
					+ "VALUES (?,?, ?, ?, ?, ?, ?)";
			PreparedStatement prepStm = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			System.out.print(SQL);
			prepStm.setString(1, obj.getName());
			prepStm.setString(2, obj.getLogin());
			prepStm.setString(3, obj.getPassword());
			prepStm.setString(4, obj.getEmail());
			prepStm.setString(5, obj.getPhone());
			prepStm.setString(6, obj.getDescription());
			prepStm.setBoolean(7, obj.isAvailable());
			prepStm.executeUpdate();
			Integer lastInsertId = null;
			ResultSet genKeys = prepStm.getGeneratedKeys();
			while (genKeys.next())
			{
				lastInsertId = genKeys.getInt(ID_USER);
			}
			UserDTO new_obj = find(lastInsertId);
			prepStm.close();
			return new_obj;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(UserDTO obj)
	{
		boolean status = false;
		try
		{
			String SQL = "DELETE FROM " + TABLE + " WHERE " + ID_USER + " = ? ";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setInt(1, obj.getIdUser());
			status = prepStm.execute();
			prepStm.close();
			return status;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return status;
		}
	}

	@Override
	public boolean update(UserDTO obj)
	{
		boolean status = false;
		try
		{
			String SQL = "UPDATE " + TABLE + " SET " + LOGIN + " = ?, " + PASSWORD + " = ?, " + EMAIL + " = ?, " + PHONE + " = ?, " + DESCRIPTION + " = ?, " + AVAILABLE + " = ?)";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setString(1, obj.getLogin());
			prepStm.setString(2, obj.getPassword());
			prepStm.setString(3, obj.getEmail());
			prepStm.setString(4, obj.getPhone());
			prepStm.setString(5, obj.getDescription());
			prepStm.setBoolean(6, obj.isAvailable());
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
	public UserDTO find(int id)
	{
		UserDTO obj = new UserDTO();
		try
		{
			String SQL = "SELECT " + NAME + ", " + LOGIN + ", " + PASSWORD + ", " + EMAIL + ", " + PHONE + ", " + DESCRIPTION + ", " + AVAILABLE + " FROM " + TABLE + " WHERE " + ID_USER + " = ?";
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			prepStm.setInt(1, id);
			ResultSet rs = prepStm.executeQuery();
			while (rs.next())
			{
				obj.setIdUser(id);
				obj.setName(rs.getString(NAME));
				obj.setLogin(rs.getString(LOGIN));
				obj.setPassword(rs.getString(PASSWORD));
				obj.setEmail(rs.getString(EMAIL));
				obj.setPhone(rs.getString(PHONE));
				obj.setDescription(rs.getString(DESCRIPTION));
				obj.setAvailable(rs.getBoolean(AVAILABLE));
			}
			return obj;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<UserDTO> findAll()
	{
		List<UserDTO> list = new ArrayList<UserDTO>();
		try
		{
			String SQL = "SELECT " + ID_USER + ", " + NAME + ", " + LOGIN + ", " + PASSWORD + ", " + EMAIL + ", " + PHONE + ", " + DESCRIPTION + ", " + AVAILABLE + " FROM " + TABLE;
			PreparedStatement prepStm = connection.prepareStatement(SQL);
			ResultSet rs = prepStm.executeQuery();
			while (rs.next())
			{
				UserDTO obj = new UserDTO(rs.getInt(ID_USER), rs.getString(NAME), rs.getString(LOGIN), rs.getString(PASSWORD), rs.getString(EMAIL), rs.getString(PHONE), rs.getString(DESCRIPTION),
						rs.getBoolean(AVAILABLE));
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