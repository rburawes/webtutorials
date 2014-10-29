<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sample</title>
</head>
<body>
<h1>
	Hello World!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<br>
This example is using spring TAG:
<br>

First name:&nbsp;<spring:eval expression="@samplePropertyConfigurer.getProperty('sample.firstname')" /><br>
Last name:&nbsp;<spring:eval expression="@samplePropertyConfigurer.getProperty('sample.lastname')" /><br>
<br>

<br>
This example is using JSTL via EL:
<br>
First name:&nbsp;<c:out value="${samplePropertyConfigurer['sample.jstl.firstname']}"/><br>
Last name:&nbsp;<c:out value="${samplePropertyConfigurer['sample.jstl.lastname']}"/><br>
</body>
</html>
