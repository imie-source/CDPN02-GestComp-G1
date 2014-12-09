package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_projet", unique=true, nullable=false)
	private Integer idProjet;

	@Column(length=128)
	private String title;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_person_person", nullable=false)
	private Person person;

	//bi-directional many-to-many association to Person
	@ManyToMany
	@JoinTable(
		name="project_person_assoc"
		, joinColumns={
			@JoinColumn(name="id_projet_project", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_person_person", nullable=false)
			}
		)
	private List<Person> persons;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
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

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}