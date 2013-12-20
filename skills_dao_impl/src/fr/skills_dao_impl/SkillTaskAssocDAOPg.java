package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.SkillTaskAssocDAO;
import fr.skills_dto.SkillTaskAssocDTO;

public class SkillTaskAssocDAOPg implements SkillTaskAssocDAO {

	private final Connection connection;

	public SkillTaskAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public SkillTaskAssocDTO create(SkillTaskAssocDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		String req = "INSERT INTO skill_task_assoc (id_task, id_skill) VALUES (?, ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getId_task());
			stmtUpdate.setInt(2, obj.getId_skill());
			stmtUpdate.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean delete(SkillTaskAssocDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		Integer vres = 0;
		String req = "DELETE FROM skill_task_assoc WHERE id_task = ? AND id_skill = ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getId_task());
			stmtUpdate.setInt(2, obj.getId_skill());
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
	public boolean update(SkillTaskAssocDTO obj)
	{
		// Pas d'update pour cette table.
		return false;
	}

	@Override
	public SkillTaskAssocDTO find(int id)
	{
		// Pas de get par un Id pour cette table.
		return null;
	}

	@Override
	public List<SkillTaskAssocDTO> findbySkill(Integer id)
	{
		List<SkillTaskAssocDTO> lstTS = new ArrayList<SkillTaskAssocDTO>();
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_task, id_skill FROM skill_task_assoc WHERE id_user = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				SkillTaskAssocDTO n = new SkillTaskAssocDTO(rs.getInt(1), rs.getInt(2));
				lstTS.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstTS;
	}

	@Override
	public List<SkillTaskAssocDTO> findbyTask(Integer id)
	{
		List<SkillTaskAssocDTO> lstTS = new ArrayList<SkillTaskAssocDTO>();
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_task, id_skill FROM skill_task_assoc WHERE id_task = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				SkillTaskAssocDTO n = new SkillTaskAssocDTO(rs.getInt(1), rs.getInt(2));
				lstTS.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstTS;
	}

	@Override
	public List<SkillTaskAssocDTO> findAll()
	{
		List<SkillTaskAssocDTO> lstTS = new ArrayList<SkillTaskAssocDTO>();
		Statement stmtQuery = null;
		ResultSet rs = null;
		try
		{
			stmtQuery = connection.createStatement();
			rs = stmtQuery.executeQuery("SELECT id_task, id_skill " + "FROM skill_task_assoc");
			while (rs.next())
			{
				SkillTaskAssocDTO n = new SkillTaskAssocDTO(rs.getInt(1), rs.getInt(2));
				lstTS.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstTS;
	}
}
