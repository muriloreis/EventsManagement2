<%-- 
    Document   : add
    Created on : Dec 8, 2014, 6:27:01 PM
    Author     : Murilo
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar Usuario</h1>
        <div class="message">
            ${message}
        </div>
        <form:form commandName="user" action="${pageContext.request.contextPath}/User/${action}">
            <label>Nome:</label> 
                <form:input path="nome"/> <br/>
            <label>Username:</label> 
                <form:input path="username"/> <br/>
            <label>Password:</label>
                <form:password path="password"/> <br/>
                <button type="submit">${button}</button>
        </form:form>
        <a href="${pageContext.request.contextPath}">Home Page</a>
    </body>
</html>
