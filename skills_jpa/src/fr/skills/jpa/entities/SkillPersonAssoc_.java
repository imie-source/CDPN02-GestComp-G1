package fr.skills.jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.632+0100")
@StaticMetamodel(SkillPersonAssoc.class)
public class SkillPersonAssoc_ {
	public static volatile SingularAttribute<SkillPersonAssoc, SkillPersonAssocPK> id;
	public static volatile SingularAttribute<SkillPersonAssoc, String> levelSkill;
	public static volatile SingularAttribute<SkillPersonAssoc, Person> person;
	public static volatile SingularAttribute<SkillPersonAssoc, Skill> skill;
}
