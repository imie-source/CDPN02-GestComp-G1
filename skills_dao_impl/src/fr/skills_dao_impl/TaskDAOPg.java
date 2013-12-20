package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.skills_dao_int.DAO;
import fr.skills_dto.Status;
import fr.skills_dto.TaskDTO;

public class TaskDAOPg implements DAO<TaskDTO> {

	private static String tableName = "task";
	private static Logger LOGGER = Logger.getLogger(TaskDAOPg.class.getName());

	private final Connection connection;

	public TaskDAOPg(Connection aConnection)
	{
		connection = aConnection;
	}

	@Override
	public ArrayList<TaskDTO> findAll()
	{
		ArrayList<TaskDTO> vRet = new ArrayList<TaskDTO>(0);

		StringBuilder vUpdateString = new StringBuilder();
		vUpdateString.append("select ");
		vUpdateString.append("*");
		vUpdateString.append(" from ");
		vUpdateString.append(tableName);

		try
		{
			ResultSet result;
			PreparedStatement vUpdate = connection.prepareStatement(vUpdateString.toString());
			result = vUpdate.executeQuery();
			while (result.next())
			{
				vRet.add(new TaskDTO(result.getInt("id_task"), result.getString("title"), result.getLong("estimated_duration"), Status.getStatus(result.getInt("status")), result
						.getInt("id_projet_PROJECT")));
			}
		} catch (SQLException e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
		return vRet;
	}

	@Override
	public TaskDTO create(TaskDTO obj)
	{
		TaskDTO vRet = new TaskDTO();

		StringBuilder vUpdateString = new StringBuilder();
		vUpdateString.append("insert into ");
		vUpdateString.append(tableName);
		vUpdateString.append(" (\"title\",\"estimated_duration\",\"status\",\"id_projet_project\") values( ?, ?, ?, ?)");

		try
		{
			PreparedStatement vUpdate = connection.prepareStatement(vUpdateString.toString(), Statement.RETURN_GENERATED_KEYS);
			if ((obj.getNameTask() != null) && (obj.getEstimatedDurationTask() != null) && (obj.getStatusTask().getValue() != null) && (obj.getIdProjet() != null))
			{
				vUpdate.setString(1, obj.getNameTask());
				vUpdate.setLong(2, obj.getEstimatedDurationTask());
				vUpdate.setInt(3, obj.getStatusTask().getValue());
				vUpdate.setInt(4, obj.getIdProjet());
				vUpdate.executeUpdate();
				ResultSet vRes = vUpdate.getGeneratedKeys();
				if (vRes.next())
				{
					obj.setIdTask(vRes.getInt(1));
				}
			}
		} catch (SQLException e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
		return vRet;
	}

	@Override
	public boolean delete(TaskDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		StringBuilder vUpdateString = new StringBuilder();
		vUpdateString.append("Delete from ");
		vUpdateString.append(tableName);
		vUpdateString.append(" where id_task = ?");

		try
		{
			PreparedStatement vUpdate = connection.prepareStatement(vUpdateString.toString());
			if (obj.getIdTask() != null)
			{

				vUpdate.setInt(1, obj.getIdTask());
				result = vUpdate.executeUpdate();
				if (result != 0)
				{
					vRet = Boolean.TRUE;
				}
			}
		} catch (SQLException e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
		return vRet;
	}

	@Override
	public boolean update(TaskDTO obj)
	{
		Boolean vRet = Boolean.FALSE;

		Integer result;
		StringBuilder vUpdateString = new StringBuilder();
		vUpdateString.append("update ");
		vUpdateString.append(tableName);
		vUpdateString.append(" set(title = ?, estimated_duration = ?,status = ?, idProjet = ?)");
		vUpdateString.append(" where id_task = ?");

		try
		{
			PreparedStatement vUpdate = connection.prepareStatement(vUpdateString.toString());
			vUpdate.setString(1, obj.getNameTask());
			vUpdate.setLong(2, obj.getEstimatedDurationTask());
			vUpdate.setInt(3, obj.getStatusTask().getValue());
			vUpdate.setInt(4, obj.getIdProjet());
			vUpdate.setInt(5, obj.getIdTask());

			result = vUpdate.executeUpdate();

			if (result != 0)
			{
				vRet = Boolean.TRUE;
			}

		} catch (SQLException e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
		return vRet;
	}

	@Override
	public TaskDTO find(int id)
	{
		TaskDTO vRet = null;

		ResultSet result;
		StringBuilder vUpdateString = new StringBuilder();
		vUpdateString.append("select * from ");
		vUpdateString.append(tableName);
		vUpdateString.append(" where id_task = ?");

		try
		{
			PreparedStatement vUpdate = connection.prepareStatement(vUpdateString.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			vUpdate.setInt(1, id);
			result = vUpdate.executeQuery();
			if (result.first())
			{
				vRet = new TaskDTO(result.getInt("id_task"), result.getString("title"), result.getLong("estimated_duration"), Status.getStatus(result.getInt("status")),
						result.getInt("id_projet_PROJECT"));
			}
		} catch (SQLException e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
		return vRet;
	}

}
