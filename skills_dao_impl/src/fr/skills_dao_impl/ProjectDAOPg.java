package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.ProjectDTO;

public class ProjectDAOPg implements DAO<ProjectDTO> {

	protected final String TABLE = "PROJECT";
	protected final String ID = "id";
	protected final String NAME = "title";

	private final Connection connection;

	public ProjectDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public ProjectDTO create(ProjectDTO project)
	{
		Integer vId = 0;
		try
		{

			String name = project.getName();
			String sql = "INSERT INTO " + TABLE + " (" + NAME + ") VALUES (?)";
			PreparedStatement createProject = connection.prepareStatement(sql);
			createProject.setString(1, name);
			ResultSet keyset = createProject.getGeneratedKeys();
			createProject.executeUpdate();
			while (keyset.next())
			{
				vId = keyset.getInt(ID);
			}
			project.setId(vId);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		project.setId(vId);
		return project;
	}

	@Override
	public boolean delete(ProjectDTO project)
	{
		Boolean vRet = Boolean.FALSE;
		Integer result;
		try
		{

			Integer id = project.getId();
			String sql = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
			PreparedStatement deleteProject = connection.prepareStatement(sql);
			deleteProject.setInt(1, id);
			result = deleteProject.executeUpdate();
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
	public boolean update(ProjectDTO project)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;

		try
		{
			String name = project.getName();
			Integer id = project.getId();
			String sql = "UPDATE" + TABLE + " SET " + NAME + " = ? WHERE id_fonction = ?";

			PreparedStatement updateProject = connection.prepareStatement(sql);
			updateProject.setString(1, name);
			updateProject.setInt(2, id);
			result = updateProject.executeUpdate();
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
	public ProjectDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectDTO> findAll()
	{
		List<ProjectDTO> vRet = new ArrayList<ProjectDTO>(0);
		ResultSet result;
		try
		{
			String sql = "SELECT * FROM " + TABLE;
			PreparedStatement findAllProject = connection.prepareStatement(sql);
			result = findAllProject.executeQuery();
			while (result.next())
			{
				vRet.add(new ProjectDTO(result.getInt(ID), result.getString(NAME)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
