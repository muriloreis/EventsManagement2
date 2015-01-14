<%-- 
    Document   : index.jsp
    Created on : Dec 8, 2014, 6:22:22 PM
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
        <h3>Seja bem vindo, ${usuario} &nbsp;&nbsp; 
            <a href="${pageContext.request.contextPath}/User/${link1}">${link1Label}</a>
            | <a href="${pageContext.request.contextPath}/User/${link2}">${link2Label}</a>
            | <a href="${pageContext.request.contextPath}/User/${link3}">${link3Label}</a>
            ${(link4 != null) ? "|" : null} <a href="${pageContext.request.contextPath}/User/${link4}">${link4Label}</a>
            ${(link5 != null) ? "|" : null} <a href="${pageContext.request.contextPath}/User/${link5}">${link5Label}</a>
        </h3>
        <form:form commandName="nomeEvento" action="${pageContext.request.contextPath}/Event/busca">
            <form:input path="nome"/>
            <button type="submit">Buscar</button>
        </form:form>
        <br/>
        <br/>
        <h1>User Functions</h1>
        <a href="${pageContext.request.contextPath}/User/List">List Users</a> <br>
        <a href="${pageContext.request.contextPath}/User/addForm">Add User</a> <br>
        
        <h1>Event Functions</h1>
        <a href="${pageContext.request.contextPath}/Event/List">List Event</a> <br>
        <a href="${pageContext.request.contextPath}/Event/addForm">Add Event</a> <br>
        
        <h1>Activity Functions</h1>
        <a href="${pageContext.request.contextPath}/Activity/List">List Activity</a> <br>
        <a href="${pageContext.request.contextPath}/Activity/addForm">Add Activity</a> <br>
    </body>
</html>
