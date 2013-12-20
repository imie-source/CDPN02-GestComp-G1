package fr.skills_dto;

public class PermissionDTO {
	/*****************************************VARIABLES***********************************************/
	private Integer idPermission;
	private String namePermission;
	/*****************************************METHODES************************************************/
	public PermissionDTO(){
		this.idPermission = null;
		this.namePermission = null;
	}
	
	public PermissionDTO(Integer anId, String aNomNature){
		this.idPermission = anId;
		this.namePermission = aNomNature;
	}
	/*****************************************GETTERS & SETTERS***************************************/
	public Integer getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}

	public String getNamePermission() {
		return namePermission;
	}

	public void setNamePermission(String namePermission) {
		this.namePermission = namePermission;
	}

}
