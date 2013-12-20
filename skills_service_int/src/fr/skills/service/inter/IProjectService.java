package fr.skills.service.inter;

import java.util.List;

import fr.skills.dto.ProjectDTO;

public interface IProjectService {

	public ProjectDTO create(ProjectDTO aProjectDTO);

	public Boolean delete(ProjectDTO aProjectDTO);

	public Boolean update(ProjectDTO aProjectDTO);

	public ProjectDTO find(Integer anId);

	public List<ProjectDTO> findAll();

	public Boolean isOK(String anAction, final ProjectDTO aProjectDTO);
}
