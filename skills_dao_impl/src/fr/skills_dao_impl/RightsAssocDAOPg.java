package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.RightsAssocDAO;
import fr.skills_dto.RightsAssocDTO;

public class RightsAssocDAOPg implements RightsAssocDAO {
	private final Connection connection;

	public RightsAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public RightsAssocDTO create(RightsAssocDTO obj)
	{
		try
		{
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("INSERT INTO permission (id_fonctions, id_permission, id_profil) VALUES ('" + obj.getIdFonction() + "','" + obj.getIdPermission() + "','" + obj.getIdProfil() + "')");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;

	}

	@Override
	public boolean delete(RightsAssocDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
					"DELETE rightsassoc WHERE ( id_profil =" + obj.getIdProfil() + " AND id_permission =" + obj.getIdPermission() + " AND id_fonction =" + obj.getIdFonction() + ")");
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
	public boolean update(RightsAssocDTO obj)
	{
		return false;
	}

	@Override
	public RightsAssocDTO find(int id)
	{
		return null;
	}

	@Override
	public List<RightsAssocDTO> findAll()
	{
		List<RightsAssocDTO> vRet = new ArrayList<RightsAssocDTO>(0);
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM rightsassoc");
			while (result.next())
			{
				vRet.add(new RightsAssocDTO(result.getInt(1), result.getInt(2), result.getInt(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public List<RightsAssocDTO> findAllByIdProfil(int id)
	{
		List<RightsAssocDTO> vRet = new ArrayList<RightsAssocDTO>(0);
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM rightsassoc WHERE id_profil =" + id);
			while (result.next())
			{
				vRet.add(new RightsAssocDTO(result.getInt(1), result.getInt(2), result.getInt(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public List<RightsAssocDTO> findAllByIdPermission(int id)
	{
		List<RightsAssocDTO> vRet = new ArrayList<RightsAssocDTO>(0);
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM rightsassoc WHERE id_permission =" + id);
			while (result.next())
			{
				vRet.add(new RightsAssocDTO(result.getInt(1), result.getInt(2), result.getInt(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public ArrayList<RightsAssocDTO> findAllByIdFonction(int id)
	{
		ArrayList<RightsAssocDTO> vRet = new ArrayList<RightsAssocDTO>(0);
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM rightsassoc WHERE id_fonction =" + id);
			while (result.next())
			{
				vRet.add(new RightsAssocDTO(result.getInt(1), result.getInt(2), result.getInt(3)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
