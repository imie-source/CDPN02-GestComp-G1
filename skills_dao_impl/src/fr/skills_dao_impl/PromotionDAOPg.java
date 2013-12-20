package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dto.PromotionDTO;

public class PromotionDAOPg implements DAO<PromotionDTO> {
	protected final String TABLE = "PROMOTION";
	protected final String ID_PROMOTION = "id_promotion";
	protected final String NAME = "name";
	protected final String DATE = "date";

	private final Connection connection;

	public PromotionDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public List<PromotionDTO> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionDTO create(PromotionDTO obj)
	{
		try
		{
			Statement stm = connection.createStatement();
			String SQL = "INSERT INTO " + TABLE + " (" + NAME + ", " + DATE + ")" + "VALUES (" + obj.getName() + "," + obj.getDate() + ")";
			stm.executeUpdate(SQL);
			int lastInsertId = Statement.RETURN_GENERATED_KEYS;
			PromotionDTO new_obj = find(lastInsertId);
			stm.close();
			return new_obj;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(PromotionDTO obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PromotionDTO obj)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PromotionDTO find(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
