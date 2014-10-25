package edu.review;

import javax.ejb.Local;

@Local
public interface GreetingLocal {
	
	public String sayHello( String name );
	
	public String sayHi( String name );

}
