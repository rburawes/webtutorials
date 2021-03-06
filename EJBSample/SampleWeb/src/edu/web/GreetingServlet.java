package edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.review.GreetingLocal;

/**
 * Servlet implementation class SalutationServlet
 */
@WebServlet( "/GreetingServlet" )
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GreetingLocal greeting;
			
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GreetingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
	      IOException {
		doPost( request, response );
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
	      IOException {
		processRequest( request, response );
	}
	
	protected void processRequest( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
	      IOException {
		response.setContentType( "text/html;charset=UTF-8" );
		PrintWriter out = response.getWriter();
		try {
			out.println( "<html>" );
			out.println( "<head>" );
			out.println( "<title>Servlet Greeting!</title>" );
			out.println( "</head>" );
			out.println( "<body>" );
			out.println( "<h1>" + greeting.sayHello( "Rae Burawes" ) + "</h1>" );
			out.println( "</body>" );
			out.println( "</html>" );
		} finally {
			out.flush();
			out.close();
		}
	}
	
}
