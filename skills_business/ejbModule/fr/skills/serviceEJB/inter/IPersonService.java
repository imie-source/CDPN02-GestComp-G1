package fr.skills.serviceEJB.inter;

import java.util.List;

import javax.ejb.Local;

import skills_jpa.Person;
import fr.skills.serviceEJB.impl.PersonDTO;
@Local
public interface IPersonService {
	public PersonDTO findById(int anId);
	public void update(Person aPerson);
	
	public List<PersonDTO> getAll();
	Boolean remove(int anId);
	PersonDTO checkLogin(PersonDTO personDto);
	PersonDTO createPerson(PersonDTO p);

}
