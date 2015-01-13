<%-- 
    Document   : pagamento
    Created on : Jan 13, 2015, 4:08:55 PM
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
        <h1>Adicionar Usuario</h1>
        <div class="message">
            ${message}
        </div>
            <form:form commandName="pagamento" method="post" action="${pageContext.request.contextPath}/Pagamento">
            <form:input style="display: none" path="eventoId" value="${id}"/>
            <label for="evento">Evento:</label> 
                <p id="evento">${evento}</p>
            <label for="usuario">Usuario:</label> 
                <p id="usuario">${usuario}</p>
            <label for="dinheiro">Quantia:</label>
                <form:input id="dinheiro" path="quantia"/> <br/>
            <label for="select-perfil">Forma de Pagamento</label>    
            <form:select path="tipo">                
                <form:option value="DINHEIRO">Dinheiro</form:option>
                <form:option value="CREDITO">Credito</form:option>
                <form:option value="DEBITO">Debito</form:option>
            </form:select>
            <br/>
           <button type="submit">Pagar</button>
        </form:form>
    </body>
</html>
