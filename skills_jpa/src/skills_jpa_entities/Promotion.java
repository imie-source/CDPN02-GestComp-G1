package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@Table(name="promotion")
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_promotion", unique=true, nullable=false)
	private Integer idPromotion;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length=80)
	private String name;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="promotion")
	private List<Person> persons;

	public Promotion() {
	}

	public Integer getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(Integer idPromotion) {
		this.idPromotion = idPromotion;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPromotion(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPromotion(null);

		return person;
	}

}