package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.SkillDTO;

public class SkillDAOPg implements DAO<SkillDTO> {
	protected final String TABLE = "SKILL";
	protected final String ID = "id_skill";
	protected final String NAME = "name";

	private final Connection connection;

	public SkillDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public SkillDTO create(SkillDTO skill)
	{
		Integer vId = 0;
		try
		{
			String name = skill.getName();
			String sql = "INSERT INTO " + TABLE + " (" + NAME + ") VALUES (?)";
			PreparedStatement createSkill = connection.prepareStatement(sql);
			createSkill.setString(1, name);
			ResultSet keyset = createSkill.getGeneratedKeys();
			createSkill.executeUpdate();
			while (keyset.next())
			{
				vId = keyset.getInt(ID);
			}
			skill.setId(vId);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		skill.setId(vId);
		return skill;
	}

	@Override
	public boolean delete(SkillDTO skill)
	{
		Boolean vRet = Boolean.FALSE;
		Integer result;
		try
		{
			Integer id = skill.getId();
			String sql = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
			PreparedStatement deleteSkill = connection.prepareStatement(sql);
			deleteSkill.setInt(1, id);
			result = deleteSkill.executeUpdate();
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
	public boolean update(SkillDTO skill)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			String name = skill.getName();
			Integer id = skill.getId();
			String sql = "UPDATE" + TABLE + " SET " + NAME + " = ? WHERE id_fonction = ?";
			PreparedStatement updateSkill = connection.prepareStatement(sql);
			updateSkill.setString(1, name);
			updateSkill.setInt(2, id);
			result = updateSkill.executeUpdate();
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
	public SkillDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillDTO> findAll()
	{
		List<SkillDTO> vRet = new ArrayList<SkillDTO>(0);
		ResultSet result;
		try
		{
			String sql = "SELECT * FROM " + TABLE;
			PreparedStatement findAllSkill = connection.prepareStatement(sql);
			result = findAllSkill.executeQuery();
			while (result.next())
			{
				vRet.add(new SkillDTO(result.getInt(ID), result.getString(NAME)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
