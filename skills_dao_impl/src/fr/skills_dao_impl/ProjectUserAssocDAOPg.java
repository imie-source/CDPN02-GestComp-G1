package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.ProjectUserAssocDTO;

public class ProjectUserAssocDAOPg implements DAO<ProjectUserAssocDTO> {

	protected final String TABLE = "PROJECT_USER_ASSOC";
	protected final String IDUSER = "idUser";
	protected final String IDPROJECT = "idProject";

	private final Connection connection;

	public ProjectUserAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public ProjectUserAssocDTO create(ProjectUserAssocDTO projectUserAssoc)
	{
		try
		{
			Integer idUser = projectUserAssoc.getIdUser();
			Integer idProject = projectUserAssoc.getIdProject();
			String sql = "INSERT INTO " + TABLE + " VALUES (?,?)";
			PreparedStatement createProjectUserAssoc = connection.prepareStatement(sql);
			createProjectUserAssoc.setInt(1, idUser);
			createProjectUserAssoc.setInt(2, idProject);
			createProjectUserAssoc.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return projectUserAssoc;
	}

	@Override
	public boolean delete(ProjectUserAssocDTO projectUserAssoc)
	{
		Boolean vRet = Boolean.FALSE;
		Integer result;
		try
		{
			Integer idUser = projectUserAssoc.getIdUser();
			Integer idProject = projectUserAssoc.getIdProject();
			String sql = "DELETE FROM " + TABLE + " WHERE " + IDUSER + " = ? AND " + IDPROJECT + "= ?";
			PreparedStatement deleteProjectUserAssoc = connection.prepareStatement(sql);
			deleteProjectUserAssoc.setInt(1, idUser);
			deleteProjectUserAssoc.setInt(2, idProject);
			result = deleteProjectUserAssoc.executeUpdate();
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
	public boolean update(ProjectUserAssocDTO projectUserAssoc)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProjectUserAssocDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectUserAssocDTO> findAll()
	{
		List<ProjectUserAssocDTO> vRet = new ArrayList<ProjectUserAssocDTO>(0);
		ResultSet result;
		try
		{
			String sql = "SELECT * FROM " + TABLE;
			PreparedStatement findAllProjectLeader = connection.prepareStatement(sql);
			result = findAllProjectLeader.executeQuery();
			while (result.next())
			{
				vRet.add(new ProjectUserAssocDTO(result.getInt(IDUSER), result.getInt(IDPROJECT)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
