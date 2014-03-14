package fr.skills.dto;


public class UserDTO {

	
	// DECLARATION DES VARIABLES
	private Integer idUser;
	private String name;
	private String login;
	private String password;
	private String email;
	private String phone;
	private String description;
	private boolean available;
	
	
	// CONSTRUCTEURS
	public UserDTO(){
	}
	public UserDTO(Integer idUser, String name, String login, String password, String email, String phone, String description, boolean available){
		this.idUser = idUser;
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.description = description;
		this.available = available;
	}

	// GETTERS & SETTERS
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

}