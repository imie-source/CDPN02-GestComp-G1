package fr.skills.jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.624+0100")
@StaticMetamodel(Project.class)
public class Project_ {
	public static volatile SingularAttribute<Project, Integer> idProjet;
	public static volatile SingularAttribute<Project, String> title;
	public static volatile SingularAttribute<Project, Person> person;
	public static volatile ListAttribute<Project, Person> persons;
	public static volatile ListAttribute<Project, Task> tasks;
}
