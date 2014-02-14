package fr.skills.jpa.impl.temp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.skills.dto.UserDTO;
import fr.skills.service.impl.UserService;

/**
 * Servlet implementation class ServletTestJPA1
 */
@WebServlet("/ServletTestJPA1")
public class ServletTestJPA1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceUnit(unitName = "skills_jpa")
	private EntityManagerFactory factory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestJPA1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityManager em = factory.createEntityManager();

		EntityTransaction transac = em.getTransaction();
		transac.begin();

		UserService userService = new UserService(factory);

		UserDTO vPerson = new UserDTO();
		vPerson.setAvailable(true);
		vPerson.setDescription("Glandu pour le test");
		vPerson.setEmail("Jean@Jean.com");
		vPerson.setLogin("Jexxcvwvxcvan");
		vPerson.setName("Jean");
		vPerson.setPassword("aqwzsx");
		vPerson.setPhone("0600000000");

		userService.create(vPerson);
		transac.commit();

		System.out.println(userService.find(1).toString());
		System.out.println(userService.find(91).toString());

		for (UserDTO vUser : userService.findAll()) {
			System.out.println(vUser.toString());
		}

		vPerson = userService.find(1);
		vPerson.setName("GLLLLLLLLLLLLLLANDU");
		userService.update(vPerson);

		userService.delete(userService.find(2));

		for (UserDTO vUser : userService.findAll()) {
			System.out.println(vUser.toString());
		}

		em.close();

		System.out.println("test");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
