package fr.skills.dto;

public class ProfileDTO {
	
	
	// DECLARATION DES VARIABLES
	private Integer idProfile;
	private String name;
	private Integer idParent;
	
	
	// CONSTRUCTEURS
	public ProfileDTO(){};
	public ProfileDTO(Integer idProfil, Integer idParent, String name){
		this.idProfile = idProfil;
		this.idParent = idParent;
		this.name = name;
	}
	
	
	// GETTERS & SETTERS
	public Integer getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(Integer idProfil) {
		this.idProfile = idProfil;
	}
	public Integer getIdParent() {
		return idParent;
	}
	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};
}
