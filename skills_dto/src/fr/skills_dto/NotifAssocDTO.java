package fr.skills_dto;

public class NotifAssocDTO {
	/** VARIABLES ############################################################################## */
    private Integer idNotification;
    private Integer idUser;
    
    /** CONSTRUCTEURS ########################################################################## */
	public NotifAssocDTO(Integer idNotification, Integer idUser) {
		this.setIdNotification(idNotification);
		this.setIdUser(idUser);
	}

	public NotifAssocDTO() {}

	/** GETTERS & SETTERS ####################################################################### */
	public Integer getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Integer idNotification) {
		this.idNotification = idNotification;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	

}
