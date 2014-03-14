package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name="permission")
public class PermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permission")
	private Integer idPermission;

	@Column(name="name_permission")
	private String namePermission;

	//bi-directional many-to-one association to RightsAssocEntity
	@OneToMany(mappedBy="permission")
	private List<RightsAssocEntity> rightsAssocs;

	public PermissionEntity() {
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

	public List<RightsAssocEntity> getRightsAssocs() {
		return this.rightsAssocs;
	}

	public void setRightsAssocs(List<RightsAssocEntity> rightsAssocs) {
		this.rightsAssocs = rightsAssocs;
	}

	public RightsAssocEntity addRightsAssoc(RightsAssocEntity rightsAssoc) {
		getRightsAssocs().add(rightsAssoc);
		rightsAssoc.setPermission(this);

		return rightsAssoc;
	}

	public RightsAssocEntity removeRightsAssoc(RightsAssocEntity rightsAssoc) {
		getRightsAssocs().remove(rightsAssoc);
		rightsAssoc.setPermission(null);

		return rightsAssoc;
	}

}