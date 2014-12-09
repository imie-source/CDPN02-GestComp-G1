package fr.skills.serviceEJB.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.skills.jpa.entities.Person;
import fr.skills.persist.PersonEJB;
import fr.skills.serviceEJB.inter.IPersonService;

@Stateless
public class PersonService implements IPersonService{

	@EJB
	private PersonEJB person;
	

	@Override
	public PersonDTO findById(int anId) {
		Person p = person.findById(anId);
		return new PersonDTO(p.getName(), p.getDescription(), p.getAvailable());
		//return  person.findById(anId);
	}

	@Override
	public void update(Person aPerson) {
		person.update(aPerson);
	}

	@Override
	public List<PersonDTO> getAll() {
		List<PersonDTO> lst = new ArrayList<PersonDTO>();
		for(Person p : person.findAll()){
			lst.add(new PersonDTO(p.getName(), p.getDescription(), p.getAvailable()));
		}
		return lst;
	}


}
