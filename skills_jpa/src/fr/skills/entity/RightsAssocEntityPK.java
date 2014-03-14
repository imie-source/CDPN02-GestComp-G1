package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rights_assoc database table.
 * 
 */
@Embeddable
public class RightsAssocEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_profile_profile")
	private Integer idProfileProfile;

	@Column(name="id_fonction_fonction")
	private Integer idFonctionFonction;

	@Column(name="id_permission_permission")
	private Integer idPermissionPermission;

	public RightsAssocEntityPK() {
	}
	public Integer getIdProfileProfile() {
		return this.idProfileProfile;
	}
	public void setIdProfileProfile(Integer idProfileProfile) {
		this.idProfileProfile = idProfileProfile;
	}
	public Integer getIdFonctionFonction() {
		return this.idFonctionFonction;
	}
	public void setIdFonctionFonction(Integer idFonctionFonction) {
		this.idFonctionFonction = idFonctionFonction;
	}
	public Integer getIdPermissionPermission() {
		return this.idPermissionPermission;
	}
	public void setIdPermissionPermission(Integer idPermissionPermission) {
		this.idPermissionPermission = idPermissionPermission;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RightsAssocEntityPK)) {
			return false;
		}
		RightsAssocEntityPK castOther = (RightsAssocEntityPK)other;
		return 
			this.idProfileProfile.equals(castOther.idProfileProfile)
			&& this.idFonctionFonction.equals(castOther.idFonctionFonction)
			&& this.idPermissionPermission.equals(castOther.idPermissionPermission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProfileProfile.hashCode();
		hash = hash * prime + this.idFonctionFonction.hashCode();
		hash = hash * prime + this.idPermissionPermission.hashCode();
		
		return hash;
	}
}