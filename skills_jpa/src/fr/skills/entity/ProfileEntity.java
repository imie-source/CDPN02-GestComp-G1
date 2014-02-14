package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
public class ProfileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profile")
	private Integer idProfile;

	private String name;

	//bi-directional many-to-many association to PersonEntity
	@ManyToMany
	@JoinTable(
		name="person_profile_assoc"
		, joinColumns={
			@JoinColumn(name="id_profile_profile")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_person_person")
			}
		)
	private List<PersonEntity> persons;

	//bi-directional many-to-one association to ProfileEntity
	@ManyToOne
	@JoinColumn(name="id_profile1")
	private ProfileEntity profile;

	//bi-directional many-to-one association to ProfileEntity
	@OneToMany(mappedBy="profile")
	private List<ProfileEntity> profiles;

	//bi-directional many-to-one association to RightsAssocEntity
	@OneToMany(mappedBy="profile")
	private List<RightsAssocEntity> rightsAssocs;

	public ProfileEntity() {
	}

	public Integer getIdProfile() {
		return this.idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PersonEntity> getPersons() {
		return this.persons;
	}

	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}

	public ProfileEntity getProfile() {
		return this.profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

	public List<ProfileEntity> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<ProfileEntity> profiles) {
		this.profiles = profiles;
	}

	public ProfileEntity addProfile(ProfileEntity profile) {
		getProfiles().add(profile);
		profile.setProfile(this);

		return profile;
	}

	public ProfileEntity removeProfile(ProfileEntity profile) {
		getProfiles().remove(profile);
		profile.setProfile(null);

		return profile;
	}

	public List<RightsAssocEntity> getRightsAssocs() {
		return this.rightsAssocs;
	}

	public void setRightsAssocs(List<RightsAssocEntity> rightsAssocs) {
		this.rightsAssocs = rightsAssocs;
	}

	public RightsAssocEntity addRightsAssoc(RightsAssocEntity rightsAssoc) {
		getRightsAssocs().add(rightsAssoc);
		rightsAssoc.setProfile(this);

		return rightsAssoc;
	}

	public RightsAssocEntity removeRightsAssoc(RightsAssocEntity rightsAssoc) {
		getRightsAssocs().remove(rightsAssoc);
		rightsAssoc.setProfile(null);

		return rightsAssoc;
	}

}