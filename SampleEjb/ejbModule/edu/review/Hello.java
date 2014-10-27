package edu.review;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Hello
 */
@Singleton
@LocalBean
public class Hello implements HelloLocal{
	
	private static final String DATE_AND_TIME = "yyyy-MM-dd HH:mm:ss.ZZZ";
	
	public Hello() {
	}
	
	public String sayHelloAndTime() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat( DATE_AND_TIME );
		return String.format( "Hello World! The date and time is '%s'", sdf.format( cal.getTime() ) );
		
	}
	
}
