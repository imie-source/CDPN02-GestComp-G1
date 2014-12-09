package fr.skills.serviceEJB.impl;

import javax.ejb.EJB;

import fr.skills.serviceEJB.inter.IPersonService;

public class Test {
	
	public static void main(String[] args) {
		IPersonService ps = new PersonService();
		System.out.println(ps.getAll());
	}

}
