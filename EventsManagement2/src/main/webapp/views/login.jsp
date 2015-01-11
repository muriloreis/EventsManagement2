<%-- 
    Document   : login
    Created on : Jan 11, 2015, 2:51:04 PM
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
        <h1>Login</h1>
        <div class="message">
            <h3 style="color: red">${message}</h3>
        </div>
        <form:form commandName="login" action="${pageContext.request.contextPath}/login">
            <label for="username">Username:</label> 
                <form:input id="username" path="username"/> <br/>
            <label for="password">Password:</label>
                <form:password id="password" path="password"/> <br/>
                <button type="submit">Entrar</button>
        </form:form>
        <a href="${pageContext.request.contextPath}">Home Page</a>
    </body>
</html>

