package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name="permission")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permission", unique=true, nullable=false)
	private Integer idPermission;

	@Column(name="name_permission", length=25)
	private String namePermission;

	//bi-directional many-to-one association to RightsAssoc
	@OneToMany(mappedBy="permission")
	private List<RightsAssoc> rightsAssocs;

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

	public List<RightsAssoc> getRightsAssocs() {
		return this.rightsAssocs;
	}

	public void setRightsAssocs(List<RightsAssoc> rightsAssocs) {
		this.rightsAssocs = rightsAssocs;
	}

	public RightsAssoc addRightsAssoc(RightsAssoc rightsAssoc) {
		getRightsAssocs().add(rightsAssoc);
		rightsAssoc.setPermission(this);

		return rightsAssoc;
	}

	public RightsAssoc removeRightsAssoc(RightsAssoc rightsAssoc) {
		getRightsAssocs().remove(rightsAssoc);
		rightsAssoc.setPermission(null);

		return rightsAssoc;
	}

}