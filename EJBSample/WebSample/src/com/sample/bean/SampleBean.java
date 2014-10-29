package com.sample.bean;

import java.util.ArrayList;
import java.util.List;

public class SampleBean {
	
	private String firstName;
	private String lastName;
	private List<Book> books = new ArrayList<Book>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks( List<Book> books ) {
		this.books = books;
	}
	
}
