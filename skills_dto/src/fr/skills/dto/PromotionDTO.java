package fr.skills.dto;

import java.util.Date;

public class PromotionDTO {

	
	// DECLARATION DES VARIABLES
	private Integer idPromotion;
	private String name;
	private Date date; 
	
	
	// CONSTRUCTEURS
	public PromotionDTO(){};
	public PromotionDTO(Integer idPromotion, String name, Date date){
		this.idPromotion = idPromotion;
		this.name = name;
		this.date = date;
	}
	
	
	// GETTERS & SETTERS
	public Integer getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(Integer idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	};
	
	
}
