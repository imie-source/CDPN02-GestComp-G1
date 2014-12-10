package fr.skills.persist;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import skills_jpa.Person;

/**
 * Session Bean implementation class PersonEJB
 */
@Stateless
@LocalBean
public class PersonEJB {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public PersonEJB() {
		// TODO Auto-generated constructor stub
	}

	public Person findById(int anId) {
		Person vRet = em.find(Person.class, anId);
		return vRet;
	}

	public void update(Person aPerson) {
		Person vRet = em.merge(aPerson);
		save(vRet);
	}

	public void save(Person aPerson) {
		em.persist(aPerson);
	}

	public List<Person> findAll() {
		//return (List<Person>) em.find(Person.class, null);
		return (List<Person>) em.createNamedQuery("Person.findAll").getResultList();
			
	}

}
