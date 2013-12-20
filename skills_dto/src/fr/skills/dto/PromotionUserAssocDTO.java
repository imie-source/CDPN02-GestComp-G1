package fr.skills.dto;

public class PromotionUserAssocDTO {
	/** VARIABLES ############################################################################## */
	private Integer id_promotion;
	private Integer id_user;

    /** CONSTRUCTEURS ########################################################################## */
	public PromotionUserAssocDTO(Integer id_promotion, Integer id_user) {
		this.id_promotion = id_promotion;
		this.id_user = id_user;
	}
	
	public PromotionUserAssocDTO() {
	}

	/** GETTERS & SETTERS ####################################################################### */
	public Integer getId_promotion() {
		return id_promotion;
	}
	public void setId_promotion(Integer id_promotion) {
		this.id_promotion = id_promotion;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
}
