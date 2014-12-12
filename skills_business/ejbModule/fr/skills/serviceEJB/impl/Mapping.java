package fr.skills.serviceEJB.impl;

import skills_jpa.Person;

public class Mapping {

	public static Person toPersonJPA(PersonDTO p){
		Person personJPA = new Person();	
		personJPA.setDescription(p.getDescription());
		personJPA.setAvailable(p.getStatus());
		personJPA.setEmail(p.getEmail());
		personJPA.setIdPerson(p.getId());
		personJPA.setLogin(p.getLogin());
		personJPA.setName(p.getName());
		personJPA.setPhone(p.getPhone());
		personJPA.setPswd(p.getPswd());
		return personJPA;
	}
	
	public static PersonDTO toPersonDTO(Person p){
		PersonDTO personDTO = new PersonDTO();	
		personDTO.setDescription(p.getDescription());
		personDTO.setStatus(p.getAvailable());
		personDTO.setEmail(p.getEmail());
		personDTO.setId(p.getIdPerson());
		personDTO.setLogin(p.getLogin());
		personDTO.setName(p.getName());
		personDTO.setPhone(p.getPhone());
		personDTO.setPswd(p.getPswd());
		return personDTO;
	}
	
}
