package edu.service;

import javax.ejb.EJB;
import javax.jws.WebService;

import edu.review.HelloLocal;

@WebService
public class Hello {
	
	@EJB
	private HelloLocal hello;
	
	public String sayHello(){
		
		return hello.sayHelloAndTime();
	}
	
}
