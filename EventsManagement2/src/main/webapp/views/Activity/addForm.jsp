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
        <h1>Adicionar Atividade</h1>
        <div class="message">
            ${message}
        </div>
        <form:form commandName="activity" action="${pageContext.request.contextPath}/Activity/${action}">
            <label>Nome:</label> 
                <form:input path="nome"/> <br/>
            <label>Descricao:</label> 
                <form:input path="descricao"/> <br/>
            <label>Evento:</label> 
                <form:input path="evento"/> <br/>
             <button type="submit">${button}</button>
        </form:form>
        <a href="${pageContext.request.contextPath}">Home Page</a>
    </body>
</html>
