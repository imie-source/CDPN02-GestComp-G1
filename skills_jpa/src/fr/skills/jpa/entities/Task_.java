package fr.skills.jpa.entities;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.635+0100")
@StaticMetamodel(Task.class)
public class Task_ {
	public static volatile SingularAttribute<Task, Integer> idTask;
	public static volatile SingularAttribute<Task, Timestamp> estimatedDuration;
	public static volatile SingularAttribute<Task, Integer> status;
	public static volatile SingularAttribute<Task, String> title;
	public static volatile SingularAttribute<Task, Project> project;
	public static volatile ListAttribute<Task, Skill> skills;
}
