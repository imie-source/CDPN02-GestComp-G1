package fr.skills.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rights_assoc database table.
 * 
 */
@Embeddable
public class RightsAssocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_profile_profile", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idProfileProfile;

	@Column(name="id_fonction_fonction", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idFonctionFonction;

	@Column(name="id_permission_permission", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idPermissionPermission;

	public RightsAssocPK() {
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
		if (!(other instanceof RightsAssocPK)) {
			return false;
		}
		RightsAssocPK castOther = (RightsAssocPK)other;
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