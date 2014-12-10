package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permission")
	private Integer idPermission;

	@Column(name="name_permission")
	private String namePermission;

	public Permission() {
	}

	public Integer getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}

	public String getNamePermission() {
		return this.namePermission;
	}

	public void setNamePermission(String namePermission) {
		this.namePermission = namePermission;
	}

}