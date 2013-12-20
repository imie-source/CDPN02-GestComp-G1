package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.PermissionDTO;

public class PermissionDAOPg implements DAO<PermissionDTO> {

	private final Connection connection;

	public PermissionDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public PermissionDTO create(PermissionDTO obj)
	{
		Integer vId = 0;
		try
		{
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("INSERT INTO permission (name_permission) VALUES ('" + obj.getNamePermission() + "')", Statement.RETURN_GENERATED_KEYS);
			ResultSet keyset = stmt.getGeneratedKeys();
			while (keyset.next())
			{
				vId = keyset.getInt(1);
			}
			obj.setIdPermission(vId);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean delete(PermissionDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM permission WHERE id_permission = " + obj.getIdPermission());
			if (result != 0)
			{
				vRet = Boolean.TRUE;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public boolean update(PermissionDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
					"UPDATE permission SET name_permission  ='" + obj.getNamePermission() + "' WHERE id_permission = " + obj.getIdPermission());
			if (result != 0)
			{
				vRet = Boolean.TRUE;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public PermissionDTO find(int id)
	{
		PermissionDTO vRet = new PermissionDTO();
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM permission WHERE id_permission=" + id);
			if (result.first())
			{
				vRet = new PermissionDTO(result.getInt(1), result.getString(2));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public List<PermissionDTO> findAll()
	{
		List<PermissionDTO> vRet = new ArrayList<PermissionDTO>(0);
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM permission");
			while (result.next())
			{
				vRet.add(new PermissionDTO(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
