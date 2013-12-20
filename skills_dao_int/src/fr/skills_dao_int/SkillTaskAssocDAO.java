package fr.skills_dao_int;

import java.util.List;

import fr.skills_dto.SkillTaskAssocDTO;

public interface SkillTaskAssocDAO extends DAO<SkillTaskAssocDTO> {

	public List<SkillTaskAssocDTO> findbySkill(Integer id);

	public List<SkillTaskAssocDTO> findbyTask(Integer id);
}
