package skills_views;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.skills.serviceEJB.impl.PersonDTO;
import fr.skills.serviceEJB.inter.IPersonService;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member-list")
public class MemberListServlet extends AuthServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IPersonService personService;
	
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
		super.setRouteName("member", request);
//		super.verifyAuthentication(request, response);
		
		this.loadMemberList(request, response);
		this.getServletContext().getRequestDispatcher( "/views/template/layout.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.setRouteName("member", request);
//		super.verifyAuthentication(request, response);
		
		super.jAlert("Attention, vérifiez bien que vous n'êtes pas trop débile.", request);
		
		this.loadMemberList(request, response);
		this.getServletContext().getRequestDispatcher( "/views/template/layout.jsp" ).forward( request, response );
	}
	
	public void loadMemberList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String pageTitle = "Liste des membres";
		request.setAttribute( "pageTitle", pageTitle );
		String jspName = "../pages/member-list.jsp";
		request.setAttribute( "jspName", jspName );
		List<PersonDTO> memberList = personService.getAll();
		session.setAttribute("memberList", memberList);
	}

}
