package fr.skills.dao.inter;

import java.util.List;

import fr.skills.dto.SkillTaskAssocDTO;

public interface SkillTaskAssocDAO extends DAO<SkillTaskAssocDTO> {

	public List<SkillTaskAssocDTO> findbySkill(Integer id);

	public List<SkillTaskAssocDTO> findbyTask(Integer id);
}
