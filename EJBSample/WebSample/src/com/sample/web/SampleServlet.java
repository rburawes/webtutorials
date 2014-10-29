package com.sample.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.bean.Book;
import com.sample.bean.SampleBean;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet(description = "This is sample and study servlet.", urlPatterns = { "/SampleServlet" })
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book1 = new Book();
		book1.setName( "Pro Spring 3" );
		book1.setEdition( 2 );
		
		Book book2 = new Book();
		book2.setName( "Pro JPA" );
		book2.setEdition( 2 );
		
		List<Book> books = new ArrayList<Book>();
		books.add( book1 );
		books.add( book2 );
		
		SampleBean collector = new SampleBean();
		collector.setFirstName( "John" );
		collector.setLastName( "Doe" );
		collector.setBooks( books );
		
		HttpSession session = request.getSession();
		session.setAttribute( "collectorBean", collector );
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/bookCollection.jsp");
		rd.forward( request, response );
		
	}

}
