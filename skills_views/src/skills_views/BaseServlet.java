package skills_views;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.skills.serviceEJB.inter.IPersonService;

/**
 * Servlet implementation class BaseServlet
 */
//@WebServlet("")
public class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	protected IPersonService personService;
       
	
	public void setRouteName(String routeName, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("curPage", routeName);
		System.out.println(routeName); 															// DEBUG
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
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
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
