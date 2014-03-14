package fr.skills.service.inter;

import java.util.List;

import fr.skills.dto.TaskDTO;

public interface ITaskService {

	public TaskDTO create(TaskDTO aTaskDTO);

	public Boolean delete(TaskDTO aTaskDTO);

	public Boolean update(TaskDTO aTaskDTO);

	public TaskDTO find(Integer anId);

	public List<TaskDTO> findAll();

	public Boolean isOK(String anAction, final TaskDTO aTaskDTO);
}
