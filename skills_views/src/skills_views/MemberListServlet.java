package skills_views;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.skills.serviceEJB.impl.PersonDTO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member-list")
public class MemberListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set route name
		super.setRouteName("member", request);
		this.loadMemberList(request, response);
		this.loadPage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// set route name
		super.setRouteName("member", request);
		// jAlert
		if(request.getParameter("jAlert") != null){
			System.out.println(request.getParameter("jAlert"));												// DEBUG
			if(request.getParameter("jAlert").equals("added")){
				Integer id = Integer.valueOf(request.getParameter("id"));
				PersonDTO person = new PersonDTO();
				person.setId(id);
				PersonDTO res = personService.findById(person);
				super.jAlert(res.getName()+" a bien été ajouté.", request);
			}else if(request.getParameter("jAlert").equals("removed")){
				String name = request.getParameter("name");
				super.jAlert(name+" a bien été supprimé.", request);
			}
			else if(request.getParameter("jAlert").equals("updated")){
				String name = request.getParameter("name");
				super.jAlert(name+" a bien été mis à jour.", request);
			}
		}
	}
	
	public void loadPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pageTitle = "Liste des membres";
		request.setAttribute( "pageTitle", pageTitle );
		String jspName = "../pages/member-list.jsp";
		request.setAttribute( "jspName", jspName );
		this.getServletContext().getRequestDispatcher( "/views/template/layout.jsp" ).forward( request, response );
	}
	
	public void loadMemberList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		List<PersonDTO> memberList = personService.getAll();
		session.setAttribute("memberList", memberList);
	}

}
