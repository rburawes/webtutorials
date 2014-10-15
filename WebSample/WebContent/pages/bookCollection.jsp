<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="collectorBean" class="com.sample.bean.SampleBean" scope="session" /> 

Collector Details:

<br><br>

First Name: <jsp:getProperty property="firstName" name="collectorBean"/>
Last Name: <jsp:getProperty property="lastName" name="collectorBean"/>

<br><br>

Books:

<br><br>

<c:forEach items="${collectorBean.books}" var="book">

Name: <c:out value="${book.name}" />, Edition: <c:out value="${book.edition}"/> <br>

</c:forEach>
</body>
</html>