package fr.skills_dto;

public class TaskDTO {

	private Integer idTask;
	private String nameTask;
	private Long estimatedDurationTask;
	private Status statusTask;
	private Integer idProjet;

	public TaskDTO()
	{
		idTask = null;
		nameTask = null;
		estimatedDurationTask = null;
		statusTask = null;
	}

	public TaskDTO(Integer anIdTask, String aNameTask, Long anEstimatedDurationTask, Status aStatusTask, Integer anIdProjet)
	{
		idTask = anIdTask;
		nameTask = aNameTask;
		estimatedDurationTask = anEstimatedDurationTask;
		statusTask = aStatusTask;
		idProjet = anIdProjet;
	}

	public Integer getIdProjet()
	{
		return idProjet;
	}

	public void setIdProjet(Integer idProjet)
	{
		this.idProjet = idProjet;
	}

	public Integer getIdTask()
	{
		return idTask;
	}

	public void setIdTask(Integer idTask)
	{
		this.idTask = idTask;
	}

	public String getNameTask()
	{
		return nameTask;
	}

	public void setNameTask(String nameTask)
	{
		this.nameTask = nameTask;
	}

	public Long getEstimatedDurationTask()
	{
		return estimatedDurationTask;
	}

	public void setEstimatedDurationTask(Long estimatedDurationTask)
	{
		this.estimatedDurationTask = estimatedDurationTask;
	}

	public Status getStatusTask()
	{
		return statusTask;
	}

	public void setStatusTask(Status statusTask)
	{
		this.statusTask = statusTask;
	}
}
