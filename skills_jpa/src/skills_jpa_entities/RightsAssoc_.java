package skills_jpa_entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.627+0100")
@StaticMetamodel(RightsAssoc.class)
public class RightsAssoc_ {
	public static volatile SingularAttribute<RightsAssoc, RightsAssocPK> id;
	public static volatile SingularAttribute<RightsAssoc, Fonction> fonction;
	public static volatile SingularAttribute<RightsAssoc, Permission> permission;
	public static volatile SingularAttribute<RightsAssoc, Profile> profile;
}
