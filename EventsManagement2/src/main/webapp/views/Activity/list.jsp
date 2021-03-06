<%-- 
    Document   : list
    Created on : Dec 8, 2014, 6:39:37 PM
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
        <table>
            <thead>
                <tr>
                    <th width="">ID</th>
                    <th width="">Nome</th>
                    <th width="">Descricao</th>
                    <th width="">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="activity" items="${activities}">
                    <tr>
                        <td>${activity.idatividade}</td>
                        <td>${activity.nome}</td>
                        <td>${activity.descricao}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Activity/editForm/${activity.idatividade}">Edit</a> | 
                            <a href="${pageContext.request.contextPath}/Activity/delete/${activity.idatividade}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <a href="${pageContext.request.contextPath}">Home Page</a>
            </tbody>
        </table>
    </body>
</html>
