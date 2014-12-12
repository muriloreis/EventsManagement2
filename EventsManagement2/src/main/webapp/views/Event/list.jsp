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
        <p>${message}</p>
        <table>
            <thead>
                <tr>
                    <th width="">ID</th>
                    <th width="">Nome</th>
                    <th width="">Descricao</th>
                    <th width="">Criador</th>
                    <th width="">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.nome}</td>
                        <td>${event.descricao}</td>
                        <td>${event.criador}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Event/editForm/${event.id}">Edit</a> | 
                            <a href="${pageContext.request.contextPath}/Event/delete/${event.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <a href="${pageContext.request.contextPath}">Home Page</a>
            </tbody>
        </table>
    </body>
</html>
