package skills_jpa_entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.622+0100")
@StaticMetamodel(Profile.class)
public class Profile_ {
	public static volatile SingularAttribute<Profile, Integer> idProfile;
	public static volatile SingularAttribute<Profile, String> name;
	public static volatile ListAttribute<Profile, Person> persons;
	public static volatile SingularAttribute<Profile, Profile> profile;
	public static volatile ListAttribute<Profile, Profile> profiles;
	public static volatile ListAttribute<Profile, RightsAssoc> rightsAssocs;
}
