package fr.skills.jpa.impl.temp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.skills.dto.UserDTO;
import fr.skills.entity.PersonEntity;

/**
 * Servlet implementation class ServletTestJPA1
 */
@WebServlet("/ServletTestJPA1")
public class ServletTestJPA1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceUnit(unitName="skills_jpa")
	private EntityManagerFactory factory;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestJPA1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		EntityManager em = factory.createEntityManager();    

		EntityTransaction transac = em.getTransaction();
		transac.begin();

		
		PersonEntity vPerson = new PersonEntity();
		vPerson.setAvailable(true);
		vPerson.setDescription("Glandu pour le test");
		vPerson.setEmail("Jean@Jean.com");
		vPerson.setLogin("Jean");
		vPerson.setName("Jean");
		vPerson.setPswd("aqwzsx");
		vPerson.setPhone("0600000000");
		
		em.persist(vPerson);
		
		transac.commit();
		
		em.close();   
		  

		System.out.println("test");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
