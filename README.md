webtutorials
============

These are sample codes that I've used during my self-study and review on Java EE technologies.
Feel free to use or copy them.

1. Servlets, JSP and JSTL
2. EJB's session beans and MDB
3. JPA
4. Spring

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
	c. Web service sample url: http://localhost:8080/SampleService/HelloService?Tester

Spring Sample Project:

Sample codes using Spring Framework.

1. spring-property-file-sample - A demonstration on how to configure and use multiple property files in Spring and display the values in JSP using Spring Tag or JSTL.

		a.Look at root-context.xml for property file configuration.
		b. To display the values in JSP using JSTL via EL, set 'exposeContextBeansAsAttributes' of InternalResourceViewResolver.
		c. See servlet-context.xml for InternalResourceViewResolver configuration.
