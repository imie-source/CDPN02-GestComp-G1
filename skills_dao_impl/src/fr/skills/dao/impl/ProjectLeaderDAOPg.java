package fr.skills.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.skills.dao.inter.DAO;
import fr.skills.dto.ProjectLeaderDTO;

public class ProjectLeaderDAOPg implements DAO<ProjectLeaderDTO> {
	protected final String TABLE = "PROJECT_LEADER";
	protected final String IDUSER = "idUser";
	protected final String IDPROJECT = "idProject";

	private final Connection connection;

	public ProjectLeaderDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public List<ProjectLeaderDTO> findAll()
	{
		List<ProjectLeaderDTO> vRet = new ArrayList<ProjectLeaderDTO>(0);
		ResultSet result;
		try
		{
			String sql = "SELECT * FROM " + TABLE;
			PreparedStatement findAllProjectLeader = connection.prepareStatement(sql);
			result = findAllProjectLeader.executeQuery();
			while (result.next())
			{
				vRet.add(new ProjectLeaderDTO(result.getInt(IDUSER), result.getInt(IDPROJECT)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

	@Override
	public ProjectLeaderDTO create(ProjectLeaderDTO projectLeader)
	{
		try
		{
			Integer idUser = projectLeader.getIdUser();
			Integer idProject = projectLeader.getIdProject();
			String sql = "INSERT INTO " + TABLE + " VALUES (?,?)";
			PreparedStatement createProjectLeader = connection.prepareStatement(sql);
			createProjectLeader.setInt(1, idUser);
			createProjectLeader.setInt(2, idProject);
			createProjectLeader.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return projectLeader;
	}

	@Override
	public boolean delete(ProjectLeaderDTO projectLeader)
	{
		Boolean vRet = Boolean.FALSE;
		Integer result;
		try
		{
			Integer idUser = projectLeader.getIdUser();
			Integer idProject = projectLeader.getIdProject();
			String sql = "DELETE FROM " + TABLE + " WHERE " + IDUSER + " = ? AND " + IDPROJECT + "= ?";
			PreparedStatement deleteProjectLeader = connection.prepareStatement(sql);
			deleteProjectLeader.setInt(1, idUser);
			deleteProjectLeader.setInt(2, idProject);
			result = deleteProjectLeader.executeUpdate();
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
	public boolean update(ProjectLeaderDTO projectLeader)
	{
		return false;
	}

	@Override
	public ProjectLeaderDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
