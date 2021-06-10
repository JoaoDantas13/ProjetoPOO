<%-- 
    Document   : listaFuncionarios
    Created on : 9 de jun. de 2021, 19:50:39
    Author     : HOME
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardian</title>
    </head>
    <body class="container" background="../Guardian.png" bgproperties="fixed">
        <h1>Lista Funcionários</h1>

        <div class ="btnincluir">
            <a href="funcionarios/incluirFuncionario.jsp"><button type="button" class="btn btn-primary">Incluir novo Funcionario</button></a>
        </div>


        <table class="table">
            
            <th>ID</th>
            <th>Nome</th>
            <th>Setor</th>
            <th></th>
            <th></th>
            
            <c:forEach items="${listaFuncionarios}" var="funcionario">                
                <tr>                    
                    <td>${funcionario.id}</td>                    
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.setor}</td>                   
                    
                    <td><a href="AlterarFuncionarioServlet?id=${funcionario.id}"><button type="button" class="btn btn-primary">Alterar</button></a></td>
                
                    <td><a href="InativarFuncionarioServlet?id=${funcionario.id}"><button type="button" class="btn btn-primary">Deletar</button></td>
                </tr>
            </c:forEach>
        </table>

        <br/><br/>
        <br/>         
        <a href="../POO">Menu Inicial</a>                        
                
    </body>
</html>
