package skills_views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends AuthServlet {
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
		
		super.setRouteName("account", request);
		super.verifyAuthentication(request, response);
		
		// TODO Auto-generated method stub
		String pageTitle = "Mon compte";
		request.setAttribute( "pageTitle", pageTitle );
		String jspName = "../pages/account.jsp";
		request.setAttribute( "jspName", jspName );
		String content = "Mon compte";
		request.setAttribute( "content", content );
		this.getServletContext().getRequestDispatcher( "/views/template/layout.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
