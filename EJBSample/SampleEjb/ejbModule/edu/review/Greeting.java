package edu.review;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Salutation
 */
@Stateless
@LocalBean
public class Greeting implements GreetingLocal{
	
	public Greeting() {
	}
	
	public String sayHello( String name ) {
		return String.format( "Hello %s!", name );
	}
	
	public String sayHi( String name ) {
		return String.format( "Hi %s!", name );
	}
	
}
