package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_projet")
	private Integer idProjet;

	@Column(name="id_person_person")
	private Integer idPersonPerson;

	private String title;

	public Project() {
	}

	public Integer getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	public Integer getIdPersonPerson() {
		return this.idPersonPerson;
	}

	public void setIdPersonPerson(Integer idPersonPerson) {
		this.idPersonPerson = idPersonPerson;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}