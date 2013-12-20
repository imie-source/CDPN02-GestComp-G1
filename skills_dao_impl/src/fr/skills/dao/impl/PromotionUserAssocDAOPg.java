package fr.skills.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.skills.dao.inter.PromotionUserAssocDAO;
import fr.skills.dto.PromotionUserAssocDTO;

public class PromotionUserAssocDAOPg implements PromotionUserAssocDAO {

	private final Connection connection;

	public PromotionUserAssocDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public PromotionUserAssocDTO create(PromotionUserAssocDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		String req = "INSERT INTO promotion_user_assoc (id_promotion, id_user) VALUES (?, ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getId_promotion());
			stmtUpdate.setInt(2, obj.getId_user());
			stmtUpdate.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean delete(PromotionUserAssocDTO obj)
	{
		PreparedStatement stmtUpdate = null;
		Integer vres = 0;
		String req = "DELETE FROM promotion_user_assoc WHERE id_promotion = ? AND id_user = ?)";
		try
		{
			stmtUpdate = connection.prepareStatement(req);
			stmtUpdate.setInt(1, obj.getId_promotion());
			stmtUpdate.setInt(2, obj.getId_user());
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
	public boolean update(PromotionUserAssocDTO obj)
	{
		// Pas d'update pour cette table.
		return false;
	}

	@Override
	public PromotionUserAssocDTO find(int id)
	{
		// Pas de get par un Id pour cette table.
		return null;
	}

	@Override
	public List<PromotionUserAssocDTO> findbyPromotion(Integer id)
	{
		List<PromotionUserAssocDTO> lstPU = new ArrayList<PromotionUserAssocDTO>();
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_promotion, id_user FROM promotion_user_assoc WHERE id_promotion = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				PromotionUserAssocDTO n = new PromotionUserAssocDTO(rs.getInt(1), rs.getInt(2));
				lstPU.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstPU;
	}

	@Override
	public List<PromotionUserAssocDTO> findbyUser(Integer id)
	{
		List<PromotionUserAssocDTO> lstPU = new ArrayList<PromotionUserAssocDTO>();
		PreparedStatement stmtQuery = null;
		ResultSet rs = null;
		String req = "SELECT id_promotion, id_user FROM promotion_user_assoc WHERE id_user = ?";
		try
		{
			stmtQuery = connection.prepareStatement(req);
			stmtQuery.setInt(1, id);
			rs = stmtQuery.executeQuery();
			while (rs.next())
			{
				PromotionUserAssocDTO n = new PromotionUserAssocDTO(rs.getInt(1), rs.getInt(2));
				lstPU.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstPU;
	}

	@Override
	public List<PromotionUserAssocDTO> findAll()
	{
		List<PromotionUserAssocDTO> lstPU = new ArrayList<PromotionUserAssocDTO>();
		Statement stmtQuery = null;
		ResultSet rs = null;
		try
		{
			stmtQuery = connection.createStatement();
			rs = stmtQuery.executeQuery("SELECT id_promotion, id_user " + "FROM promotion_user_assoc");
			while (rs.next())
			{
				PromotionUserAssocDTO n = new PromotionUserAssocDTO(rs.getInt(1), rs.getInt(2));
				lstPU.add(n);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstPU;
	}

}
