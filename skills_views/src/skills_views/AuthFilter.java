package skills_views;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
//		String uri = ((HttpServletRequest)request).getRequestURI();
//		String testUri = ((HttpServletRequest)request).getContextPath()+"/login";
//		System.out.println(uri);
//		System.out.println(testUri);
//		Boolean filter = uri.equals(testUri);
//		System.out.println(filter);
//		if(filter){
//			chain.doFilter(request, response);
//		}else{
//			HttpSession session = ((HttpServletRequest)request).getSession();
//	    	PersonDTO user = new PersonDTO(1, "LORENT Arthur", "Stagiaire", true);
//	    	session.setAttribute("user", user);
//	    	boolean b = session.getAttribute("user") instanceof PersonDTO;
//			if(!b){
//	    		((HttpServletResponse)response).sendRedirect("./login");
//	    	}else{
	    		chain.doFilter(request, response);
//	    	}
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
