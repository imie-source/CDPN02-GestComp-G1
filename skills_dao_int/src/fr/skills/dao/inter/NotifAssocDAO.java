package fr.skills.dao.inter;

import java.util.List;

import fr.skills.dto.NotifAssocDTO;

public interface NotifAssocDAO extends DAO<NotifAssocDTO> {

	public List<NotifAssocDTO> findbyUser(Integer id);

	public List<NotifAssocDTO> findbyNotif(Integer id);
}
