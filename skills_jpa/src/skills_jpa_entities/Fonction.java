package skills_jpa_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fonction database table.
 * 
 */
@Entity
@Table(name="fonction")
@NamedQuery(name="Fonction.findAll", query="SELECT f FROM Fonction f")
public class Fonction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fonction", unique=true, nullable=false)
	private Integer idFonction;

	@Column(length=25)
	private String name;

	//bi-directional many-to-one association to RightsAssoc
	@OneToMany(mappedBy="fonction")
	private List<RightsAssoc> rightsAssocs;

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

	public List<RightsAssoc> getRightsAssocs() {
		return this.rightsAssocs;
	}

	public void setRightsAssocs(List<RightsAssoc> rightsAssocs) {
		this.rightsAssocs = rightsAssocs;
	}

	public RightsAssoc addRightsAssoc(RightsAssoc rightsAssoc) {
		getRightsAssocs().add(rightsAssoc);
		rightsAssoc.setFonction(this);

		return rightsAssoc;
	}

	public RightsAssoc removeRightsAssoc(RightsAssoc rightsAssoc) {
		getRightsAssocs().remove(rightsAssoc);
		rightsAssoc.setFonction(null);

		return rightsAssoc;
	}

}