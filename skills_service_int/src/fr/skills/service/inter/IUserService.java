package fr.skills.service.inter;

import java.util.List;

import fr.skills.dto.UserDTO;

public interface IUserService {

	public void create(UserDTO aUserDTO);

	public void delete(UserDTO aUserDTO);

	public void update(UserDTO aUserDTO);

	public UserDTO find(Integer anId);

	public List<UserDTO> findAll();
}
