package fr.skills.jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.620+0100")
@StaticMetamodel(Person.class)
public class Person_ {
	public static volatile SingularAttribute<Person, Integer> idPerson;
	public static volatile SingularAttribute<Person, Boolean> available;
	public static volatile SingularAttribute<Person, String> description;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, String> login;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, String> phone;
	public static volatile SingularAttribute<Person, String> pswd;
	public static volatile ListAttribute<Person, Notification> notifications;
	public static volatile SingularAttribute<Person, Promotion> promotion;
	public static volatile ListAttribute<Person, Profile> profiles;
	public static volatile ListAttribute<Person, Project> projects1;
	public static volatile ListAttribute<Person, Project> projects2;
	public static volatile ListAttribute<Person, SkillPersonAssoc> skillPersonAssocs;
}
