package skills_jpa_entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.614+0100")
@StaticMetamodel(Fonction.class)
public class Fonction_ {
	public static volatile SingularAttribute<Fonction, Integer> idFonction;
	public static volatile SingularAttribute<Fonction, String> name;
	public static volatile ListAttribute<Fonction, RightsAssoc> rightsAssocs;
}
