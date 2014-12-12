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
        <table>
            <thead>
                <tr>
                    <th width="">ID</th>
                    <th width="">Nome</th>
                    <th width="">Descricao</th>
                    <th width="">Evento</th>
                    <th width="">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="activity" items="${activities}">
                    <tr>
                        <td>${activity.idatividade}</td>
                        <td>${activity.nome}</td>
                        <td>${activity.descricao}</td>
                        <td>${activity.evento}</td>
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
