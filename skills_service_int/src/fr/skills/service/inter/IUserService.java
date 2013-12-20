package fr.skills.service.inter;

import java.util.List;

import fr.skills.dto.UserDTO;

public interface IUserService {

	public UserDTO create(UserDTO aUserDTO);

	public Boolean delete(UserDTO aUserDTO);

	public Boolean update(UserDTO aUserDTO);

	public UserDTO find(Integer anId);

	public List<UserDTO> findAll();
}
