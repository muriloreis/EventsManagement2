<%-- 
    Document   : pagamentoList
    Created on : Jan 13, 2015, 8:54:47 PM
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
        <h3>${message}</h3>
        <table>
            <thead>
                <tr>
                    <th width="">Cliente</th>
                    <th width="">Recebedor</th>
                    <th width="">Quantia</th>
                    <th width="">Forma de Pagamento</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pagamento" items="${pagamentos}">
                    <tr>
                        <td>${pagamento.cliente.nome}</td>
                        <td>${pagamento.recebedor.criador.nome}</td>
                        <td>${pagamento.quantia}</td>
                        <td>${pagamento.tipo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
