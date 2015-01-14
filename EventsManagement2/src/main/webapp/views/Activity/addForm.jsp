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
        <h3>Seja bem vindo, ${usuario} &nbsp;&nbsp; 
            <a href="${pageContext.request.contextPath}/User/${link1}">${link1Label}</a>
            | <a href="${pageContext.request.contextPath}/User/${link2}">${link2Label}</a>
            | <a href="${pageContext.request.contextPath}/User/${link3}">${link3Label}</a>
            ${(link4 != null) ? "|" : null} <a href="${pageContext.request.contextPath}/User/${link4}">${link4Label}</a>
            ${(link5 != null) ? "|" : null} <a href="${pageContext.request.contextPath}/User/${link5}">${link5Label}</a>
            ${(link6 != null) ? "|" : null} <a href="${pageContext.request.contextPath}/User/${link6}">${link6Label}</a>
         </h3>
        <form:form commandName="nomeEvento" action="${pageContext.request.contextPath}/Event/busca">
            <form:input path="nome"/>
            <button type="submit">Buscar</button>
        </form:form>
        <h1>Adicionar Atividade</h1>
        <div class="message">
            ${message}
        </div>
        <form:form commandName="activity" action="${pageContext.request.contextPath}/Activity/${action}">
            <label>Nome:</label> 
                <form:input path="nome"/> <br/>
            <label>Descricao:</label> 
                <form:input path="descricao"/> <br/>
             <button type="submit">${button}</button>
        </form:form>
        <a href="${pageContext.request.contextPath}">Home Page</a>
    </body>
</html>
