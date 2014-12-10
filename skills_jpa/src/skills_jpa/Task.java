package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_task")
	private Integer idTask;

	@Column(name="estimated_duration")
	private Timestamp estimatedDuration;

	@Column(name="id_projet_project")
	private Integer idProjetProject;

	private Integer status;

	private String title;

	public Task() {
	}

	public Integer getIdTask() {
		return this.idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public Timestamp getEstimatedDuration() {
		return this.estimatedDuration;
	}

	public void setEstimatedDuration(Timestamp estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	public Integer getIdProjetProject() {
		return this.idProjetProject;
	}

	public void setIdProjetProject(Integer idProjetProject) {
		this.idProjetProject = idProjetProject;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}