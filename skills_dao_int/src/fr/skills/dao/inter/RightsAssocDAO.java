package fr.skills.dao.inter;

import java.util.List;

import fr.skills.dto.RightsAssocDTO;

public interface RightsAssocDAO extends DAO<RightsAssocDTO> {

	public abstract List<RightsAssocDTO> findAllByIdPermission(int id);

	public abstract List<RightsAssocDTO> findAllByIdFonction(int id);

	public abstract List<RightsAssocDTO> findAllByIdProfil(int id);

}
