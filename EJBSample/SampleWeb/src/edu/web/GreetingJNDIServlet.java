package edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.review.GreetingLocal;

/**
 * Servlet implementation class GreetingJNDIServlet
 */
@WebServlet( "/GreetingJNDIServlet" )
public class GreetingJNDIServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private GreetingLocal greetingLocal;
	
	public void init() throws ServletException {
		
		Context context = null;
		try {
			context = new InitialContext();
			greetingLocal = ( GreetingLocal ) context.lookup( "java:global/SampleEAR/SampleEjb/Greeting!edu.review.GreetingLocal" );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GreetingJNDIServlet() {
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
			out.println( "<h1>" + greetingLocal.sayHello( "Rae Burawes, this is using JNDI" ) + "</h1>" );
			out.println( "</body>" );
			out.println( "</html>" );
		} finally {
			out.flush();
			out.close();
		}
	}
	
}
