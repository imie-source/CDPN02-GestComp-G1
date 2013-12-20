package fr.skills.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.skills.dao.inter.DAO;
import fr.skills.dto.SkillUserAssocDTO;

public class SkillUserAssocDAOPg implements DAO<SkillUserAssocDTO> {
	protected final String TABLE = "SKILL_USER_ASSOC";
	protected final String IDUSER = "id_user";
	protected final String IDSKILL = "id_skill";
	protected final String LEVELSKILL = "level_skill";

	private final Connection connection;

	public SkillUserAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public SkillUserAssocDTO create(SkillUserAssocDTO skillUserAssoc)
	{
		try
		{
			Integer idUser = skillUserAssoc.getIdUser();
			Integer idSkill = skillUserAssoc.getIdSkill();
			Integer level = skillUserAssoc.getLevelSkill();
			String sql = "INSERT INTO " + TABLE + " (" + IDUSER + "," + IDSKILL + "," + LEVELSKILL + ") VALUES (?,?,?)";
			PreparedStatement createSkillUserAssoc = connection.prepareStatement(sql);
			createSkillUserAssoc.setInt(1, idUser);
			createSkillUserAssoc.setInt(2, idSkill);
			createSkillUserAssoc.setInt(3, level);
			createSkillUserAssoc.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return skillUserAssoc;
	}

	@Override
	public boolean update(SkillUserAssocDTO skillUserAssoc)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			int idUser = skillUserAssoc.getIdUser();
			int idSkill = skillUserAssoc.getIdSkill();
			int level = skillUserAssoc.getLevelSkill();
			String sql = "UPDATE " + TABLE + " SET " + LEVELSKILL + " = ? WHERE " + IDUSER + " = ? AND " + IDSKILL + "= ? ";
			PreparedStatement updateSkillUserAssoc = connection.prepareStatement(sql);
			updateSkillUserAssoc.setInt(1, level);
			updateSkillUserAssoc.setInt(2, idUser);
			updateSkillUserAssoc.setInt(3, idSkill);
			result = updateSkillUserAssoc.executeUpdate();
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
	public boolean delete(SkillUserAssocDTO skillUserAssoc)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		try
		{
			Integer idUser = skillUserAssoc.getIdUser();
			Integer idSkill = skillUserAssoc.getIdSkill();
			String sql = "DELETE FROM " + TABLE + " WHERE " + IDUSER + " = ? AND " + IDSKILL + "=?";
			PreparedStatement deleteSkill = connection.prepareStatement(sql);
			deleteSkill.setInt(1, idUser);
			deleteSkill.setInt(1, idSkill);
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
	public SkillUserAssocDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkillUserAssocDTO> findAll()
	{
		List<SkillUserAssocDTO> vRet = new ArrayList<SkillUserAssocDTO>(0);
		ResultSet result;
		try
		{
			String sql = "SELECT * FROM " + TABLE;
			PreparedStatement findAllSkill = connection.prepareStatement(sql);
			result = findAllSkill.executeQuery();
			while (result.next())
			{
				vRet.add(new SkillUserAssocDTO(result.getInt(IDUSER), result.getInt(IDSKILL), result.getInt(LEVELSKILL)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return vRet;
	}

}
