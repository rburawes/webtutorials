package edu.review;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Stateless
@Path( "inspire" )
public class Inspire {
	
	@EJB
	private Inspiration inspire;
	
	public Inspire() {
	}
	
	@GET
	@Produces( "text/html" )
	public String processGet() {
		return getInspire();
	}
	
	@POST
	@Produces( "text/html" )
	public String processPost() {
		return getInspire();
	}
	
	private String getInspire() {
		return inspire.sendQoutes();
	}
	
}
