package skills_jpa_entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-09T10:35:59.626+0100")
@StaticMetamodel(Promotion.class)
public class Promotion_ {
	public static volatile SingularAttribute<Promotion, Integer> idPromotion;
	public static volatile SingularAttribute<Promotion, Date> date;
	public static volatile SingularAttribute<Promotion, String> name;
	public static volatile ListAttribute<Promotion, Person> persons;
}
