<%-- 
    Document   : relatorio
    Created on : Jan 14, 2015, 7:56:30 AM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
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
        <h3>${message}</h3>
        <table>
            <thead>
                <tr>
                    <th width="">Quantidade de Eventos</th>
                    <th width="">Quantia total a Receber</th>
                    <th width="">Quantidade de Inscrições</th>
                    <th width="">Quantidade de Inscritos nos Meus Eventos</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${quantidadeEventos}</td>
                    <td>${quantiaReceber}</td>
                    <td>${quantidadeInscritos}</td>
                    <td>${quantidadeInscritosMeusEventos}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
