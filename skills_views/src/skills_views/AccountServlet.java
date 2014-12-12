package skills_views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set route name
		super.setRouteName("account", request);
		// get session
		HttpSession session = request.getSession();
		// get order
		if(request.getParameter("order") == null){
			System.out.println("no order");																	// DEBUG
			// load logged account page
			this.loadLoggedAccountPage(request, response);
		}else{
			System.out.println(request.getParameter("order"));												// DEBUG
			if(request.getParameter("order").equals("logout")){
				session.removeAttribute("user");
				response.sendRedirect("./dashboard");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void loadLoggedAccountPage(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String pageTitle = "Mon compte";
		request.setAttribute( "pageTitle", pageTitle );
		String jspName = "../pages/account.jsp";
		request.setAttribute( "jspName", jspName );
		String content = "Mon compte";
		request.setAttribute( "content", content );
		this.getServletContext().getRequestDispatcher( "/views/template/layout.jsp" ).forward( request, response );
	}

}
