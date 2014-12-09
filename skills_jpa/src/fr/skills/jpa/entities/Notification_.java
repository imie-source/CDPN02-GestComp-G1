package fr.skills.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.617+0100")
@StaticMetamodel(Notification.class)
public class Notification_ {
	public static volatile SingularAttribute<Notification, Integer> idNotification;
	public static volatile SingularAttribute<Notification, String> content;
	public static volatile SingularAttribute<Notification, Date> date;
	public static volatile ListAttribute<Notification, Person> persons;
}
