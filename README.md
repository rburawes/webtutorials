webtutorials
============

Sample web applications tutorials.

WebSample Project:

Demonstration on how to use JSP's usebean and JSTL tag to display data from session.

How to run:

1. You can use any web application server e.g. tomcat.
2. Put the project on your tomcat's webapps.
3. Run tomcat.
4. Access http://localhost:8083/WebSample/SampleServlet on your browser.

EJB Sample Project:

Sample EJB projec using Eclipse and Glassfish 4.

1. Download JavaEE Kit from Oracle site. http://www.oracle.com/technetwork/java/javaee/downloads/index.html
2. Have a copy of Eclipse, here I've used Kepler.
3. Import the projects.
4. Make sure you're using Glassfish as the container for the app.

Note: Using Glassfish server admin add the following for Queue connection factory and and Queue destination.

	a. jms/GreetingQueueFactory
	b. jms/GreetingQueue
