package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@Table(name="task")
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_task")
	private Integer idTask;

	@Column(name="estimated_duration")
	private Timestamp estimatedDuration;

	private Integer status;

	private String title;

	//bi-directional many-to-many association to SkillEntity
	@ManyToMany
	@JoinTable(
		name="skill_task_assoc"
		, joinColumns={
			@JoinColumn(name="id_task_task")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_skill_skill")
			}
		)
	private List<SkillEntity> skills;

	//bi-directional many-to-one association to ProjectEntity
	@ManyToOne
	@JoinColumn(name="id_projet_project")
	private ProjectEntity project;

	public TaskEntity() {
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

	public List<SkillEntity> getSkills() {
		return this.skills;
	}

	public void setSkills(List<SkillEntity> skills) {
		this.skills = skills;
	}

	public ProjectEntity getProject() {
		return this.project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

}