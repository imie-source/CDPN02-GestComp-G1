package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_person_assoc database table.
 * 
 */
@Entity
@Table(name="project_person_assoc")
@NamedQuery(name="ProjectPersonAssoc.findAll", query="SELECT p FROM ProjectPersonAssoc p")
public class ProjectPersonAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectPersonAssocPK id;

	public ProjectPersonAssoc() {
	}

	public ProjectPersonAssocPK getId() {
		return this.id;
	}

	public void setId(ProjectPersonAssocPK id) {
		this.id = id;
	}

}