package fr.skills.serviceEJB.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.skills.jpa.entities.Person;
import fr.skills.serviceEJB.inter.IPersonService;

@Stateless
public class PersonService implements IPersonService{

	@PersistenceContext
	EntityManager em;
	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		
		return (List<Person>) em.createNamedQuery("Player.findAll").getResultList();
	}

}
