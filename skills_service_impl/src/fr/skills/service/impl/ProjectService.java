package fr.skills.service.impl;

import java.util.List;

import fr.skills.dao.inter.DAO;
import fr.skills.dao.inter.FactoryDAO;
import fr.skills.dto.ProjectDTO;

public class ProjectService {

	private final DAO<ProjectDTO> projectDAO;

	public ProjectService(FactoryDAO afdao)
	{
		projectDAO = afdao.getProjectDAO();
	}

	public ProjectDTO create(ProjectDTO aProjectDTO)
	{
		if (isOK("create", aProjectDTO))
		{
			aProjectDTO = projectDAO.create(aProjectDTO);
		}
		return aProjectDTO;
	}

	public Boolean delete(ProjectDTO aProjectDTO)
	{
		Boolean vRet = false;
		if (isOK("delete", aProjectDTO))
		{
			vRet = projectDAO.delete(aProjectDTO);
		}
		return vRet;
	}

	public Boolean update(ProjectDTO aProjectDTO)
	{
		Boolean vRet = false;
		if (isOK("update", aProjectDTO))
		{
			projectDAO.update(aProjectDTO);
		}
		return vRet;
	}

	public ProjectDTO find(Integer anId)
	{
		ProjectDTO vRet = null;
		if (anId != null)
		{
			vRet = projectDAO.find(anId);
		}
		return vRet;
	}

	public List<ProjectDTO> findAll()
	{
		return projectDAO.findAll();
	}

	public Boolean isOK(String anAction, final ProjectDTO aProjectDTO)
	{
		Boolean vRet = false;
		if (aProjectDTO != null)
		{
			switch (anAction.toLowerCase())
			{
			case "create":
				if (!aProjectDTO.getName().trim().equals(""))
				{
					vRet = true;
				}
				break;
			case "delete":
				if (aProjectDTO.getId() != null)
				{
					vRet = true;
				}
				break;

			case "update":
				if (aProjectDTO.getId() != null)
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
