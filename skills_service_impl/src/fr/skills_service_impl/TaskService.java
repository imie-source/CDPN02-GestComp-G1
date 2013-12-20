package fr.skills_service_impl;

import java.util.List;

import fr.skills_dao_int.DAO;
import fr.skills_dao_int.FactoryDAO;
import fr.skills_dto.TaskDTO;

public class TaskService {

	private final DAO<TaskDTO> taskDAO;

	public TaskService(FactoryDAO afdao)
	{
		taskDAO = afdao.getTaskDAO();
	}

	public TaskDTO create(TaskDTO aTaskDTO)
	{
		if (isOK("create", aTaskDTO))
		{
			aTaskDTO = taskDAO.create(aTaskDTO);
		}
		return aTaskDTO;
	}

	public Boolean delete(TaskDTO aTaskDTO)
	{
		Boolean vRet = false;
		if (isOK("delete", aTaskDTO))
		{
			vRet = taskDAO.delete(aTaskDTO);
		}
		return vRet;
	}

	public Boolean update(TaskDTO aTaskDTO)
	{
		Boolean vRet = false;
		if (isOK("update", aTaskDTO))
		{
			taskDAO.update(aTaskDTO);
		}
		return vRet;
	}

	public TaskDTO find(Integer anId)
	{
		TaskDTO vRet = null;
		if (anId != null)
		{
			vRet = taskDAO.find(anId);
		}
		return vRet;
	}

	public List<TaskDTO> findAll()
	{
		return taskDAO.findAll();
	}

	public Boolean isOK(String anAction, final TaskDTO aTaskDTO)
	{
		Boolean vRet = false;
		if (aTaskDTO != null)
		{
			switch (anAction.toLowerCase())
			{
			case "create":
				if ((aTaskDTO.getIdProjet() != null) && (aTaskDTO.getStatusTask() != null) && (aTaskDTO.getEstimatedDurationTask() != null) && (aTaskDTO.getEstimatedDurationTask() > 0)
						&& !aTaskDTO.getNameTask().isEmpty() && (aTaskDTO.getNameTask() != null))
				{
					vRet = true;
				}
				break;
			case "delete":
				if (aTaskDTO.getIdTask() != null)
				{
					vRet = true;
				}
				break;

			case "update":
				if ((aTaskDTO.getIdTask() != null) && (aTaskDTO.getIdProjet() != null) && (aTaskDTO.getStatusTask() != null) && (aTaskDTO.getEstimatedDurationTask() != null)
						&& (aTaskDTO.getEstimatedDurationTask() > 0) && !aTaskDTO.getNameTask().isEmpty() && (aTaskDTO.getNameTask() != null))
				{
					vRet = true;
				}
				break;
			default:
				break;
			}
		}
		return vRet;
	}
}
