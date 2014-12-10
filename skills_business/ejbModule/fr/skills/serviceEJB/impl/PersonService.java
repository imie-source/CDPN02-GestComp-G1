package fr.skills.serviceEJB.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import skills_jpa.Person;
import fr.skills.persist.PersonEJB;
import fr.skills.serviceEJB.inter.IPersonService;

@Stateless
public class PersonService implements IPersonService{

	@EJB
	private PersonEJB person;
	

	@Override
	public PersonDTO findById(int anId) {
		Person p = person.findById(anId);
		return new PersonDTO(p.getIdPerson(), p.getName(), p.getDescription(), p.getAvailable());
		//return  person.findById(anId);
	}
	
	@Override
	public void remove(int anId) {
		Person p = person.findById(anId);
		person.remove(p);
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
			lst.add(new PersonDTO(p.getIdPerson(),p.getName(), p.getDescription(), p.getAvailable()));
		}
		return lst;
	}


}
