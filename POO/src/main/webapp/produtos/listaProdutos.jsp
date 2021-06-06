<%-- 
    Document   : produto
    Created on : 5 de jun. de 2021, 21:57:32
    Author     : HOME
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            </b></b>

        <table class="table">
            
            <th>Nome</th>
            <th>Endereco</th>
            <th>Quantidade</th>
            <th></th>
            <th></th>
            
            <c:forEach items="${listaProdutos}" var="produto">                
                <tr>                    
                    <td>${produto.nome}</td>                    
                    <td>${produto.endereco}</td>
                    <td>${produto.quantidade}</td>
                    
                    <td><a href=""><button type="button" class="btn btn-primary">Alterar</button></a></td>
                
                    <td><button type="button" class="btn btn-primary" onclick="">Inativar</button></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
