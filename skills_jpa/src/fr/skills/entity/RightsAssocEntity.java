package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rights_assoc database table.
 * 
 */
@Entity
@Table(name="rights_assoc")
public class RightsAssocEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RightsAssocEntityPK id;

	//bi-directional many-to-one association to FonctionEntity
	@ManyToOne
	@JoinColumn(name="id_fonction_fonction", insertable= false, updatable=false )
	private FonctionEntity fonction;

	//bi-directional many-to-one association to PermissionEntity
	@ManyToOne
	@JoinColumn(name="id_permission_permission", insertable= false, updatable=false )
	private PermissionEntity permission;

	//bi-directional many-to-one association to ProfileEntity
	@ManyToOne
	@JoinColumn(name="id_profile_profile", insertable= false, updatable=false )
	private ProfileEntity profile;

	public RightsAssocEntity() {
	}

	public RightsAssocEntityPK getId() {
		return this.id;
	}

	public void setId(RightsAssocEntityPK id) {
		this.id = id;
	}

	public FonctionEntity getFonction() {
		return this.fonction;
	}

	public void setFonction(FonctionEntity fonction) {
		this.fonction = fonction;
	}

	public PermissionEntity getPermission() {
		return this.permission;
	}

	public void setPermission(PermissionEntity permission) {
		this.permission = permission;
	}

	public ProfileEntity getProfile() {
		return this.profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

}