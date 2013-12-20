package fr.skills_dao_int;

import java.util.List;

import fr.skills_dto.NotifAssocDTO;

public interface NotifAssocDAO extends DAO<NotifAssocDTO> {

	public List<NotifAssocDTO> findbyUser(Integer id);

	public List<NotifAssocDTO> findbyNotif(Integer id);
}
