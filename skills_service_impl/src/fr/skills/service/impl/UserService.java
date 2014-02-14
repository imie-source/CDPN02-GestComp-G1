package fr.skills.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.skills.dto.UserDTO;
import fr.skills.entity.PersonEntity;
import fr.skills.service.inter.IUserService;

public class UserService implements IUserService {

	private final EntityManager entityManager;
	
	public UserService(EntityManagerFactory aFactory) {
		entityManager = aFactory.createEntityManager();
	}

	@Override
	public void create(UserDTO aUserDTO) {
		if (isOK("create", aUserDTO)) {
			PersonEntity vPerson= new PersonEntity(aUserDTO);
			entityManager.persist(vPerson);
			
		}
	}

	@Override
	public void delete(UserDTO aUserDTO) {
		if (isOK("delete", aUserDTO)) {
			PersonEntity vPerson= new PersonEntity(aUserDTO);
			entityManager.remove(vPerson);
		}
	}

	@Override
	public void update(UserDTO aUserDTO) {
		if (isOK("update", aUserDTO)) {
			PersonEntity vPerson= new PersonEntity(aUserDTO);
			entityManager.persist(vPerson);
		}
	}

	@Override
	public UserDTO find(Integer anId) {
		UserDTO vRet = null;
//		if (anId != null) {
//			vRet = userDAO.find(anId);
//		}
		return vRet;
	}

	@Override
	public List<UserDTO> findAll() {
		return new ArrayList<UserDTO>();
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
