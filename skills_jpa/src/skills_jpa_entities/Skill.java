package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@Table(name="skill")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_skill", unique=true, nullable=false)
	private Integer idSkill;

	@Column(name="name_skill", length=128)
	private String nameSkill;

	//bi-directional many-to-one association to Skill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_skill1")
	private Skill skill;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="skill")
	private List<Skill> skills;

	//bi-directional many-to-one association to SkillPersonAssoc
	@OneToMany(mappedBy="skill")
	private List<SkillPersonAssoc> skillPersonAssocs;

	//bi-directional many-to-many association to Task
	@ManyToMany(mappedBy="skills")
	private List<Task> tasks;

	public Skill() {
	}

	public Integer getIdSkill() {
		return this.idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public String getNameSkill() {
		return this.nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setSkill(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setSkill(null);

		return skill;
	}

	public List<SkillPersonAssoc> getSkillPersonAssocs() {
		return this.skillPersonAssocs;
	}

	public void setSkillPersonAssocs(List<SkillPersonAssoc> skillPersonAssocs) {
		this.skillPersonAssocs = skillPersonAssocs;
	}

	public SkillPersonAssoc addSkillPersonAssoc(SkillPersonAssoc skillPersonAssoc) {
		getSkillPersonAssocs().add(skillPersonAssoc);
		skillPersonAssoc.setSkill(this);

		return skillPersonAssoc;
	}

	public SkillPersonAssoc removeSkillPersonAssoc(SkillPersonAssoc skillPersonAssoc) {
		getSkillPersonAssocs().remove(skillPersonAssoc);
		skillPersonAssoc.setSkill(null);

		return skillPersonAssoc;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}