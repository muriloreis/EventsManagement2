<%-- 
    Document   : detail
    Created on : Jan 13, 2015, 9:29:20 AM
    Author     : Murilo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
         </h3>
        <form:form commandName="nomeEvento" action="${pageContext.request.contextPath}/Event/busca">
            <form:input path="nome"/>
            <button type="submit">Buscar</button>
        </form:form>
        <h3><p id="nome">${nome}</p></h3>
        <label for="descricao">Descricao:</label> 
        <p id="descricao">${descricao}</p>
        <label>Atividades</label>  
        <table>
            <thead>
                <tr>
                    <th width="">Nome</th>
                    <th width="">Descricao</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="activity" items="${activities}">
                    <tr>
                        <td>${activity.nome}</td>
                        <td>${activity.descricao}</td>
                    </tr>
                </c:forEach>
            </tbody>
            <h3><a href="${pageContext.request.contextPath}/Event/inscricao/${id}">Inscreva-se</a></h3>
        </table>
    </body>
</html>
