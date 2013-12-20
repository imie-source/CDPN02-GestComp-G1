package fr.skills_dto;

public class UserProfileAssocDTO {

	
	// DECLARATION DES VARIABLES
	private Integer idUser;
	private Integer idProfile;

	
	// DECLARATION DES VARIABLES
	public UserProfileAssocDTO(){};
	public UserProfileAssocDTO(Integer idUser, Integer idProfile){
		this.idUser = idUser;
		this.idProfile = idProfile;
	}
	
	
	// GETTERS & SETTERS
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}
	
}
