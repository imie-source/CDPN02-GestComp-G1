package fr.skills.serviceEJB.inter;

import java.util.List;

import javax.ejb.Local;

import fr.skills.jpa.entities.Person;
import fr.skills.serviceEJB.impl.PersonDTO;
@Local
public interface IPersonService {
	public PersonDTO findById(int anId);
	public void update(Person aPerson);
	
	public List<PersonDTO> getAll();

}
