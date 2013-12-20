package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.FonctionDTO;

public class FonctionDAOPg implements DAO<FonctionDTO> {

	private final Connection connection;

	public FonctionDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public FonctionDTO create(FonctionDTO obj)
	{
		Integer vId = 0;
		try
		{
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate("INSERT INTO fonction (name_fonction) VALUES ('" + obj.getNameFonction() + "')", Statement.RETURN_GENERATED_KEYS);
			ResultSet keyset = stmt.getGeneratedKeys();
			while (keyset.next())
			{
				vId = keyset.getInt(1);
			}
			obj.setIdFonction(vId);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		obj.setIdFonction(vId);
		return obj;
	}

	@Override
	public boolean delete(FonctionDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM fonction WHERE id_fonction = " + obj.getIdFonction());
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
	public boolean update(FonctionDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(
					"UPDATE fonction SET name_fonction  ='" + obj.getNameFonction() + "' WHERE id_fonction = " + obj.getIdFonction());
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
	public FonctionDTO find(int id)
	{
		FonctionDTO vFonctionDTO = null;

		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fonction WHERE id_fonction = " + id);
			if (result.first())
			{
				vFonctionDTO = new FonctionDTO(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		return vFonctionDTO;
	}

	@Override
	public List<FonctionDTO> findAll()
	{
		List<FonctionDTO> vRet = new ArrayList<FonctionDTO>(0);
		ResultSet result;
		try
		{
			result = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM fonction");
			while (result.next())
			{
				vRet.add(new FonctionDTO(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
