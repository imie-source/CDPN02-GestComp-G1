package skills_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fonction database table.
 * 
 */
@Entity
@NamedQuery(name="Fonction.findAll", query="SELECT f FROM Fonction f")
public class Fonction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fonction")
	private Integer idFonction;

	private String name;

	public Fonction() {
	}

	public Integer getIdFonction() {
		return this.idFonction;
	}

	public void setIdFonction(Integer idFonction) {
		this.idFonction = idFonction;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}