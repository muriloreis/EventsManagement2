<%-- 
    Document   : menu
    Created on : Jan 13, 2015, 9:21:57 AM
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
        <h3>Seja bem vindo, ${usuario} &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/User/${link1}">${link1Label}</a> | <a href="${pageContext.request.contextPath}/User/${link2}">${link2Label}</a></h3>
        <form:form commandName="nomeEvento" action="${pageContext.request.contextPath}/Event/busca">
            <form:input path="nome"/>
            <button type="submit">Buscar</button>
        </form:form>
        <h3>${message}</h3>
        <table>
            <thead>
                <tr>
                    <th width="">Nome</th>
                    <th width="">Descricao</th>
                    <th width="">Criador</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/Event/${event.id}">${event.nome}</a></td>
                        <td>${event.descricao}</td>
                        <td>${event.criador}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
