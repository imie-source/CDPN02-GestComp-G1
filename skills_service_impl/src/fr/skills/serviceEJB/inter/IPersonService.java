package fr.skills.serviceEJB.inter;

import java.util.List;

import fr.skills.jpa.entities.Person;

public interface IPersonService {

	public List<Person> getAll();

}
