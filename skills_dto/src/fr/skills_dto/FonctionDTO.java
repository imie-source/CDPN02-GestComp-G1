package fr.skills_dto;

public class FonctionDTO {
	/*****************************************VARIABLES***********************************************/
	private Integer idFonction;
	private String nameFonction;
	
	/*****************************************CONSTRUCTORS********************************************/
	public FonctionDTO(){
		this.idFonction = null;
		this.nameFonction = null;
	}
	
	public FonctionDTO(Integer anId, String aFoncName){
		this.idFonction = anId;
		this.nameFonction = aFoncName;
	}
	
	/*****************************************GETTERS & SETTERS***************************************/	
	public Integer getIdFonction() {
		return idFonction;
	}
	
	public void setIdFonction(Integer idFonction) {
		this.idFonction = idFonction;
	}
	
	public String getNameFonction() {
		return nameFonction;
	}
	
	public void setNameFonction(String nameFonction) {
		this.nameFonction = nameFonction;
	}

}
