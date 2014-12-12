package fr.skills.persist;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public Person update(Person aPerson) {
		Person vRet = em.merge(aPerson);
		em.persist(vRet);
		return this.findById(vRet.getIdPerson());
	}

	public List<Person> findAll() {
		return (List<Person>) em.createNamedQuery("Person.findAll").getResultList();		
	}
	
	public Person remove(Person p) {
		em.remove(p);
		return p;
	}
	
	public Person checkLogin(String login, String password) {
		TypedQuery<Person> query = em.createQuery(
		        "Person.findByName = :login", Person.class);
		Person p = query.setParameter("login", login).getSingleResult();
		if(p.getPswd().equals(password)){
			return p;
		}else{
			return null;
		}
	}
	
	public Person createPerson(Person member){
		em.persist(member);		
		Person p  = em.createNamedQuery("Person.findByLogin", Person.class).setParameter("login", member.getLogin()).getSingleResult();
		return p;
	}
}
