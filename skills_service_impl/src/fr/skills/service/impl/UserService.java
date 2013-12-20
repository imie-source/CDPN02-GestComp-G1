package fr.skills.service.impl;

import java.util.List;

import fr.skills.dao.inter.DAO;
import fr.skills.dao.inter.FactoryDAO;
import fr.skills.dto.UserDTO;
import fr.skills.service.inter.IUserService;

public class UserService implements IUserService {

	private final DAO<UserDTO> userDAO;

	public UserService(FactoryDAO afdao) {
		userDAO = afdao.getUserDAO();
	}

	@Override
	public UserDTO create(UserDTO aUserDTO) {
		if (isOK("create", aUserDTO)) {
			aUserDTO = userDAO.create(aUserDTO);
		}
		return aUserDTO;
	}

	@Override
	public Boolean delete(UserDTO aUserDTO) {
		Boolean vRet = false;
		if (isOK("delete", aUserDTO)) {
			vRet = userDAO.delete(aUserDTO);
		}
		return vRet;
	}

	@Override
	public Boolean update(UserDTO aUserDTO) {
		Boolean vRet = false;
		if (isOK("update", aUserDTO)) {
			userDAO.update(aUserDTO);
		}
		return vRet;
	}

	@Override
	public UserDTO find(Integer anId) {
		UserDTO vRet = null;
		if (anId != null) {
			vRet = userDAO.find(anId);
		}
		return vRet;
	}

	@Override
	public List<UserDTO> findAll() {
		return userDAO.findAll();
	}

	private boolean isOK(String anAction, UserDTO aUserDTO) {
		Boolean vRet = false;
		if (aUserDTO != null) {
			switch (anAction.toLowerCase()) {
			case "create":
				if ((aUserDTO.getEmail() != null)
						&& (!aUserDTO.getEmail().isEmpty())
						&& (aUserDTO.getLogin() != null)
						&& (!aUserDTO.getLogin().isEmpty())
						&& (aUserDTO.getName() != null)
						&& (!aUserDTO.getName().isEmpty())
						&& (aUserDTO.getPassword() != null)
						&& (!aUserDTO.getPassword().isEmpty())
						&& (aUserDTO.getPhone() != null)
						&& (!aUserDTO.getPhone().isEmpty())) {
					vRet = true;
				}
				break;
			case "delete":
				if (aUserDTO.getIdUser() != null) {
					vRet = true;
				}
				break;

			case "update":
				if ((aUserDTO.getEmail() != null)
						&& (!aUserDTO.getEmail().isEmpty())
						&& (aUserDTO.getLogin() != null)
						&& (!aUserDTO.getLogin().isEmpty())
						&& (aUserDTO.getName() != null)
						&& (!aUserDTO.getName().isEmpty())
						&& (aUserDTO.getPassword() != null)
						&& (!aUserDTO.getPassword().isEmpty())
						&& (aUserDTO.getPhone() != null)
						&& (!aUserDTO.getPhone().isEmpty())) {
					vRet = true;
				}
				break;
			default:
				break;
			}
		}
		return vRet;
	}
}
