package fr.skills_dao_int;

import java.util.List;

import fr.skills_dto.RightsAssocDTO;

public interface RightsAssocDAO extends DAO<RightsAssocDTO> {

	public abstract List<RightsAssocDTO> findAllByIdPermission(int id);

	public abstract List<RightsAssocDTO> findAllByIdFonction(int id);

	public abstract List<RightsAssocDTO> findAllByIdProfil(int id);

}
