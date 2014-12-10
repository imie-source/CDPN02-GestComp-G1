package skills_views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/login")
public class AuthServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
	
	public void setRouteName(String routeName, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("curPage", routeName);
	}
	
	public String getRouteName(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String curPage = (String) session.getAttribute("curPage");
		if(!curPage.isEmpty()){
			return curPage;
		}else{
			return null;
		}
	}
	
	 public void jAlert(String msg, HttpServletRequest request){
		if(!msg.isEmpty()){
			HttpSession session = request.getSession();
			session.setAttribute("jAlert", msg);
		}
	}
	 
	public void jConfirm(String msg, HttpServletRequest request){
		if(!msg.isEmpty()){
			HttpSession session = request.getSession();
			session.setAttribute("jConfirm", msg);
		}
	}
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void verifyAuthentication(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	HttpSession session = request.getSession();
//    	if(session.getAttribute("user") instanceof PersonService){
//    		
//    	}else{
	    	String pageTitle = "Formulaire de connexion";
			String jspName = "../pages/login.jsp";
			request.setAttribute( "pageTitle", pageTitle );
			request.setAttribute( "jspName", jspName );
			this.getServletContext().getRequestDispatcher( "/views/template/layout.jsp" ).forward( request, response );
//    	};
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
