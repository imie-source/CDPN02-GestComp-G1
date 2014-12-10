package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profile")
	private Integer idProfile;

	private String name;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="id_profile1")
	private Profile profile;

	//bi-directional many-to-one association to Profile
	@OneToMany(mappedBy="profile")
	private List<Profile> profiles;

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

}