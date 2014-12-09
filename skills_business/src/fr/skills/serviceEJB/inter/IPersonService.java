package fr.skills.serviceEJB.inter;

import java.util.List;

import fr.skills.jpa.entities.Person;

public interface IPersonService {
	public Person findById(int anId);
	public void update(Person aPerson);
	
	public List<Person> getAll();

}
