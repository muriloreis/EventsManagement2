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
                    <th width="">First name</th>
                    <th width="">Last name</th>
                    <th width="">Username</th>
                    <th width="">Password</th>
                    <th width="">Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.iduser}</td>
                        <td>${user.nome}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/User/editForm/${user.iduser}">Edit</a> | 
                            <a href="${pageContext.request.contextPath}/User/delete/${user.iduser}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <a href="${pageContext.request.contextPath}">Home Page</a>
            </tbody>
        </table>
    </body>
</html>
