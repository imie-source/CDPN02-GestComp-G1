package fr.skills.jpa.entities;

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
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_task", unique=true, nullable=false)
	private Integer idTask;

	@Column(name="estimated_duration")
	private Timestamp estimatedDuration;

	private Integer status;

	@Column(length=80)
	private String title;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_projet_project")
	private Project project;

	//bi-directional many-to-many association to Skill
	@ManyToMany
	@JoinTable(
		name="skill_task_assoc"
		, joinColumns={
			@JoinColumn(name="id_task_task", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_skill_skill", nullable=false)
			}
		)
	private List<Skill> skills;

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

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}