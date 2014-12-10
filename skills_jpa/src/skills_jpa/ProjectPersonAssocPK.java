package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the project_person_assoc database table.
 * 
 */
@Embeddable
public class ProjectPersonAssocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_person_person", insertable=false, updatable=false)
	private Integer idPersonPerson;

	@Column(name="id_projet_project", insertable=false, updatable=false)
	private Integer idProjetProject;

	public ProjectPersonAssocPK() {
	}
	public Integer getIdPersonPerson() {
		return this.idPersonPerson;
	}
	public void setIdPersonPerson(Integer idPersonPerson) {
		this.idPersonPerson = idPersonPerson;
	}
	public Integer getIdProjetProject() {
		return this.idProjetProject;
	}
	public void setIdProjetProject(Integer idProjetProject) {
		this.idProjetProject = idProjetProject;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectPersonAssocPK)) {
			return false;
		}
		ProjectPersonAssocPK castOther = (ProjectPersonAssocPK)other;
		return 
			this.idPersonPerson.equals(castOther.idPersonPerson)
			&& this.idProjetProject.equals(castOther.idProjetProject);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersonPerson.hashCode();
		hash = hash * prime + this.idProjetProject.hashCode();
		
		return hash;
	}
}