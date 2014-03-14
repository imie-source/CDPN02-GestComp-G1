package fr.skills.entity;

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
public class PromotionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_promotion")
	private Integer idPromotion;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String name;

	//bi-directional many-to-one association to PersonEntity
	@OneToMany(mappedBy="promotion")
	private List<PersonEntity> persons;

	public PromotionEntity() {
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

	public List<PersonEntity> getPersons() {
		return this.persons;
	}

	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}

	public PersonEntity addPerson(PersonEntity person) {
		getPersons().add(person);
		person.setPromotion(this);

		return person;
	}

	public PersonEntity removePerson(PersonEntity person) {
		getPersons().remove(person);
		person.setPromotion(null);

		return person;
	}

}