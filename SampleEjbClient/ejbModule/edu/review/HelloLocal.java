package edu.review;

import javax.ejb.Local;

@Local
public interface HelloLocal {
	
	public String sayHelloAndTime();
	
}
