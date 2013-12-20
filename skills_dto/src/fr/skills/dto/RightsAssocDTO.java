package fr.skills.dto;


public class RightsAssocDTO {
	/*****************************************VARIABLES***********************************************/
	private Integer idProfil;
	private Integer idFonction;
	private Integer idPermission;
	/*****************************************METHODES************************************************/
	public RightsAssocDTO(){
		this.idProfil = null;
		this.idFonction = null;
		this.idPermission = null;
	}
	
	public RightsAssocDTO(Integer anIdProfil, Integer anIdPermission, Integer anIdFonction){
		this.idProfil = anIdProfil;
		this.idFonction = anIdFonction;
		this.idPermission = anIdPermission;
	}
	
	/*****************************************GETTERS & SETTERS***************************************/
	public Integer getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}
	public Integer getIdFonction() {
		return idFonction;
	}
	public void setIdFonction(Integer idFonction) {
		this.idFonction = idFonction;
	}
	public Integer getIdPermission() {
		return idPermission;
	}
	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}	
}
