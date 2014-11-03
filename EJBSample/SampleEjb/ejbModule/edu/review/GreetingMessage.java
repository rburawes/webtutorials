package edu.review;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: GreetingMessage
 */
@MessageDriven( mappedName = "jms/GreetingQueue", activationConfig = {
      @ActivationConfigProperty( propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge" ),
      @ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Queue" ) } )
public class GreetingMessage implements MessageListener {
	
	/**
	 * Default constructor.
	 */
	
	private static Logger logger = Logger.getLogger( GreetingMessage.class.getName() );
	
	public GreetingMessage() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see MessageListener#onMessage(Message)
	 */
	@Override
	public void onMessage( Message message ) {
		
		try {
			
			String name = message.getStringProperty( "description" );
			String id = message.getStringProperty( "customid" );
			logger.log( Level.INFO, String.format( "Message description: %s, id:%s", name, id ) );
			
			if ( message instanceof TextMessage ) {
				logger.log( Level.INFO, String.format( "Message is '%s'", ( ( TextMessage ) message ).getText() ) );
			}
			
		} catch ( JMSException e ) {
			logger.log( Level.WARNING, String.format( "Message failed to process!", e.getMessage() ) );
		}
		
	}
	
}
