<%-- 
    Document   : incluirFuncionario
    Created on : 9 de jun. de 2021, 23:48:31
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardian</title>
    </head>
    <body class="container" background="../Guardian.png" bgproperties="fixed">
        <h1>Funcionário</h1>
        
        <form action="../CadastrarFuncionarioServlet" method="POST">
        <label class="form-label">Nome</label>
        <input type="text" name="nome" required="true" class="form-control" />
        </br>
        <label class="form-label">Setor</label>
        <input type="text" name="setor" required="true" class="form-control" placeholder="Ex.: Almoxarifado, Infra, RH"/>
        </br>
        
        <button type ="submit" class="btn btn-primary">Incluir</button>
        
        </form>

                   
        <br/><br/>        
        
        
        
        <br/>         
        <a href="../FuncionarioServlet">Voltar</a>
    </body>
</html>
