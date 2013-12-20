package fr.skills_dao_int;

import java.util.List;

import fr.skills_dto.PromotionUserAssocDTO;

public interface PromotionUserAssocDAO extends DAO<PromotionUserAssocDTO> {

	public abstract List<PromotionUserAssocDTO> findbyPromotion(Integer id);

	public abstract List<PromotionUserAssocDTO> findbyUser(Integer id);
}
