package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profile", unique=true, nullable=false)
	private Integer idProfile;

	@Column(length=80)
	private String name;

	//bi-directional many-to-many association to Person
	@ManyToMany
	@JoinTable(
		name="person_profile_assoc"
		, joinColumns={
			@JoinColumn(name="id_profile_profile", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_person_person", nullable=false)
			}
		)
	private List<Person> persons;

	//bi-directional many-to-one association to Profile
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_profile1")
	private Profile profile;

	//bi-directional many-to-one association to Profile
	@OneToMany(mappedBy="profile")
	private List<Profile> profiles;

	//bi-directional many-to-one association to RightsAssoc
	@OneToMany(mappedBy="profile")
	private List<RightsAssoc> rightsAssocs;

	public Profile() {
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

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public Profile addProfile(Profile profile) {
		getProfiles().add(profile);
		profile.setProfile(this);

		return profile;
	}

	public Profile removeProfile(Profile profile) {
		getProfiles().remove(profile);
		profile.setProfile(null);

		return profile;
	}

	public List<RightsAssoc> getRightsAssocs() {
		return this.rightsAssocs;
	}

	public void setRightsAssocs(List<RightsAssoc> rightsAssocs) {
		this.rightsAssocs = rightsAssocs;
	}

	public RightsAssoc addRightsAssoc(RightsAssoc rightsAssoc) {
		getRightsAssocs().add(rightsAssoc);
		rightsAssoc.setProfile(this);

		return rightsAssoc;
	}

	public RightsAssoc removeRightsAssoc(RightsAssoc rightsAssoc) {
		getRightsAssocs().remove(rightsAssoc);
		rightsAssoc.setProfile(null);

		return rightsAssoc;
	}

}