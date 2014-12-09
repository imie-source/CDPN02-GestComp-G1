package fr.skills.serviceEJB.inter;

import java.util.List;

import fr.skills.jpa.entities.Person;
import fr.skills.serviceEJB.impl.PersonDTO;

public interface IPersonService {
	public Person findById(int anId);
	public void update(Person aPerson);
	
	public List<PersonDTO> getAll();

}
