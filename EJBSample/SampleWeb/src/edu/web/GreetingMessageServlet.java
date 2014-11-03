package edu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingMessageServlet
 */
@WebServlet( "/GreetingMessageServlet" )
public class GreetingMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger( GreetingMessageServlet.class.getName() );
	
	@Resource( mappedName = "jms/GreetingQueueFactory" )
	private QueueConnectionFactory queueConnectionFactory;
	
	@Resource( mappedName = "jms/GreetingQueue" )
	private Queue queue;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	
	public GreetingMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
	      IOException {
		// TODO Auto-generated method stub
		doPost( request, response );
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
	      IOException {
		
		try {
			
			String message = "This is a message sent from MESSAGE SERVLET!";
			String id = "GMS0001-RBS";
			String description = "A test message from servlet.";
			Connection connection = queueConnectionFactory.createConnection();
			
			Session session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
			MessageProducer msgProducer = ( MessageProducer ) session.createProducer( queue );
			
			TextMessage textMessage = session.createTextMessage();
			textMessage.setStringProperty( "description", description );
			textMessage.setStringProperty( "customid", id );
			textMessage.setText( message );
			
			msgProducer.send( textMessage );
			
			logger.log( Level.INFO, String.format( "Message sent from %s.", getServletName() ) );
			
			setPage( message, request, response );
			
		} catch ( JMSException e ) {
			logger.log( Level.WARNING, String.format( "Mesage failed from %s.", e.getMessage() ) );
		}
		
	}
	
	private void setPage( String value, HttpServletRequest request, HttpServletResponse response ) {
		
		response.setContentType( "text/html;charset=UTF-8" );
		
		PrintWriter out;
		
		try {
			out = response.getWriter();
			out.println( "<html>" );
			out.println( "<head>" );
			out.println( "<title>Servlet Greeting!</title>" );
			out.println( "</head>" );
			out.println( "<body>" );
			out.println( String.format( "<h1>Message is: %s</h1>", value ) );
			out.println( "</body>" );
			out.println( "</html>" );
			out.flush();
			out.close();
			
		} catch ( IOException e ) {
			logger.log( Level.WARNING, String.format( "Writer failed: %s.", e.getMessage() ) );
		}
		
	}
	
}
