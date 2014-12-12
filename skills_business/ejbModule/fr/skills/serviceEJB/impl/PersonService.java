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
		return Mapping.toPersonDTO(p);
	}
	
	@Override
	public Boolean remove(int anId) {
		Boolean res= false;
		Person p = person.findById(anId);
		if(p !=null){
			person.remove(p);	
			res=true;
		}
		return res;
	}

	@Override
	public void update(Person aPerson) {
		person.update(aPerson);
	}

	@Override
	public List<PersonDTO> getAll() {
		List<PersonDTO> lst = new ArrayList<PersonDTO>();
		for(Person p : person.findAll()){	
			lst.add(Mapping.toPersonDTO(p));
		}
		return lst;
	}
	
	@Override
	public PersonDTO checkLogin(PersonDTO personDto) {
		PersonDTO res = null;
		Person p = person.checkLogin(personDto.getLogin(), personDto.getPswd());
		if(p != null){
			res = Mapping.toPersonDTO(p);
		}
		return res;
	}
	
	@Override
	public PersonDTO createPerson(PersonDTO p){
		Person res = person.createPerson(Mapping.toPersonJPA(p));	
		return Mapping.toPersonDTO(res);
	}

}
