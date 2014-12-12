package fr.skills.serviceEJB.inter;

import java.util.List;

import javax.ejb.Local;

import fr.skills.serviceEJB.impl.PersonDTO;
@Local
public interface IPersonService {
	public List<PersonDTO> getAll();
	public PersonDTO checkLogin(PersonDTO personDto);
	public PersonDTO createPerson(PersonDTO p);
	public PersonDTO findById(PersonDTO personDto);
	public PersonDTO remove(PersonDTO personDto);
	public PersonDTO update(PersonDTO personDto);
}
