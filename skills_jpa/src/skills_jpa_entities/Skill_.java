package skills_jpa_entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.630+0100")
@StaticMetamodel(Skill.class)
public class Skill_ {
	public static volatile SingularAttribute<Skill, Integer> idSkill;
	public static volatile SingularAttribute<Skill, String> nameSkill;
	public static volatile SingularAttribute<Skill, Skill> skill;
	public static volatile ListAttribute<Skill, Skill> skills;
	public static volatile ListAttribute<Skill, SkillPersonAssoc> skillPersonAssocs;
	public static volatile ListAttribute<Skill, Task> tasks;
}
