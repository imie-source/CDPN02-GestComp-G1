package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rights_assoc database table.
 * 
 */
@Entity
@Table(name="rights_assoc")
@NamedQuery(name="RightsAssoc.findAll", query="SELECT r FROM RightsAssoc r")
public class RightsAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RightsAssocPK id;

	public RightsAssoc() {
	}

	public RightsAssocPK getId() {
		return this.id;
	}

	public void setId(RightsAssocPK id) {
		this.id = id;
	}

}