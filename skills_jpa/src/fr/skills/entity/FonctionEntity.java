package fr.skills.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fonction database table.
 * 
 */
@Entity
@Table(name="fonction")
public class FonctionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fonction")
	private Integer idFonction;

	private String name;

	//bi-directional many-to-one association to RightsAssocEntity
	@OneToMany(mappedBy="fonction")
	private List<RightsAssocEntity> rightsAssocs;

	public FonctionEntity() {
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

	public List<RightsAssocEntity> getRightsAssocs() {
		return this.rightsAssocs;
	}

	public void setRightsAssocs(List<RightsAssocEntity> rightsAssocs) {
		this.rightsAssocs = rightsAssocs;
	}

	public RightsAssocEntity addRightsAssoc(RightsAssocEntity rightsAssoc) {
		getRightsAssocs().add(rightsAssoc);
		rightsAssoc.setFonction(this);

		return rightsAssoc;
	}

	public RightsAssocEntity removeRightsAssoc(RightsAssocEntity rightsAssoc) {
		getRightsAssocs().remove(rightsAssoc);
		rightsAssoc.setFonction(null);

		return rightsAssoc;
	}

}