package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_projet")
	private Integer idProjet;

	private String title;

	//bi-directional many-to-one association to PersonEntity
	@ManyToOne
	@JoinColumn(name="id_person_person")
	private PersonEntity person;

	//bi-directional many-to-many association to PersonEntity
	@ManyToMany
	@JoinTable(
		name="project_person_assoc"
		, joinColumns={
			@JoinColumn(name="id_projet_project")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_person_person")
			}
		)
	private List<PersonEntity> persons;

	//bi-directional many-to-one association to TaskEntity
	@OneToMany(mappedBy="project")
	private List<TaskEntity> tasks;

	public ProjectEntity() {
	}

	public Integer getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PersonEntity getPerson() {
		return this.person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public List<PersonEntity> getPersons() {
		return this.persons;
	}

	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}

	public List<TaskEntity> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

	public TaskEntity addTask(TaskEntity task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public TaskEntity removeTask(TaskEntity task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}