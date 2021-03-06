package skills_jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p"),
@NamedQuery(name="Person.findByLogin", query="SELECT p FROM Person p WHERE p.login = :login")
})
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@Column (name="id_person") @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer idPerson;
	private Boolean available;
	private String description;
	private String email;
	private String login;
	private String name;
	private String phone;
	private String pswd;

	

	public Person() {
	}

	public Integer getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


}