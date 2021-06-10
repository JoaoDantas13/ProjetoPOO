<%-- 
    Document   : alterarFuncionario
    Created on : 9 de jun. de 2021, 22:59:24
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardian</title>
    </head>
    <body class="container" background="Guardian.png" bgproperties="fixed">
        
        <h1>Alterar Funcionario</h1>
        
        <form action="AlterarFuncionarioServlet" method="POST" >
        <label>ID</label>
        <input type="number" name="id" required="true" value="${funcionario.id}" readonly="true" class="form-control"/>
        </br>
        <label>Nome</label>
        <input type="text" name="nome" required="true" value="${funcionario.nome}" class="form-control"/>
        </br>
        <label>Setor</label>
        <input type="text" name="setor" required="true" value="${funcionario.setor}" class="form-control"/>
        </br>
        
        
        </br>
        
        <button type ="submit" class="btn btn-primary">Atualizar</button>
        
        </form>
        
        <br/>         
        <a href="../POO/FuncionarioServlet">Voltar</a>
           
    </body>
</html>
