package skills_jpa_entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.618+0100")
@StaticMetamodel(Permission.class)
public class Permission_ {
	public static volatile SingularAttribute<Permission, Integer> idPermission;
	public static volatile SingularAttribute<Permission, String> namePermission;
	public static volatile ListAttribute<Permission, RightsAssoc> rightsAssocs;
}
