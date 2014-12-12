<%-- 
    Document   : index.jsp
    Created on : Dec 8, 2014, 6:22:22 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
