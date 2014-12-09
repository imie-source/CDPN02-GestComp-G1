package fr.skills.jpa.entities;

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

	//bi-directional many-to-one association to Fonction
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fonction_fonction", nullable=false, insertable=false, updatable=false)
	private Fonction fonction;

	//bi-directional many-to-one association to Permission
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_permission_permission", nullable=false, insertable=false, updatable=false)
	private Permission permission;

	//bi-directional many-to-one association to Profile
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_profile_profile", nullable=false, insertable=false, updatable=false)
	private Profile profile;

	public RightsAssoc() {
	}

	public RightsAssocPK getId() {
		return this.id;
	}

	public void setId(RightsAssocPK id) {
		this.id = id;
	}

	public Fonction getFonction() {
		return this.fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}