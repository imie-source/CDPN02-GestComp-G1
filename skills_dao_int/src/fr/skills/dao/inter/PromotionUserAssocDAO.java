package fr.skills.dao.inter;

import java.util.List;

import fr.skills.dto.PromotionUserAssocDTO;

public interface PromotionUserAssocDAO extends DAO<PromotionUserAssocDTO> {

	public abstract List<PromotionUserAssocDTO> findbyPromotion(Integer id);

	public abstract List<PromotionUserAssocDTO> findbyUser(Integer id);
}
