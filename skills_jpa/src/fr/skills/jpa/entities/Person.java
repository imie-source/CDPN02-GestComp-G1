package fr.skills.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_person", unique=true, nullable=false)
	private Integer idPerson;

	private Boolean available;

	@Column(length=2000)
	private String description;

	@Column(length=80)
	private String email;

	@Column(length=50)
	private String login;

	@Column(length=80)
	private String name;

	@Column(length=12)
	private String phone;

	@Column(length=50)
	private String pswd;

	//bi-directional many-to-many association to Notification
	@ManyToMany
	@JoinTable(
		name="person_notif_assoc"
		, joinColumns={
			@JoinColumn(name="id_person_person", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_notification_notification", nullable=false)
			}
		)
	private List<Notification> notifications;

	//bi-directional many-to-one association to Promotion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_promotion_promotion")
	private Promotion promotion;

	//bi-directional many-to-many association to Profile
	@ManyToMany(mappedBy="persons")
	private List<Profile> profiles;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="person")
	private List<Project> projects1;

	//bi-directional many-to-many association to Project
	@ManyToMany(mappedBy="persons")
	private List<Project> projects2;

	//bi-directional many-to-one association to SkillPersonAssoc
	@OneToMany(mappedBy="person")
	private List<SkillPersonAssoc> skillPersonAssocs;

	public Person() {
	}

	public Integer getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public List<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<Project> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<Project> projects1) {
		this.projects1 = projects1;
	}

	public Project addProjects1(Project projects1) {
		getProjects1().add(projects1);
		projects1.setPerson(this);

		return projects1;
	}

	public Project removeProjects1(Project projects1) {
		getProjects1().remove(projects1);
		projects1.setPerson(null);

		return projects1;
	}

	public List<Project> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<Project> projects2) {
		this.projects2 = projects2;
	}

	public List<SkillPersonAssoc> getSkillPersonAssocs() {
		return this.skillPersonAssocs;
	}

	public void setSkillPersonAssocs(List<SkillPersonAssoc> skillPersonAssocs) {
		this.skillPersonAssocs = skillPersonAssocs;
	}

	public SkillPersonAssoc addSkillPersonAssoc(SkillPersonAssoc skillPersonAssoc) {
		getSkillPersonAssocs().add(skillPersonAssoc);
		skillPersonAssoc.setPerson(this);

		return skillPersonAssoc;
	}

	public SkillPersonAssoc removeSkillPersonAssoc(SkillPersonAssoc skillPersonAssoc) {
		getSkillPersonAssocs().remove(skillPersonAssoc);
		skillPersonAssoc.setPerson(null);

		return skillPersonAssoc;
	}

}