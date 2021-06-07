<%-- 
    Document   : alterarProduto
    Created on : 6 de jun. de 2021, 13:20:25
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
    </head>
    <body class="container" background="Guardian.png" bgproperties="fixed">
        <h1>Alterar Produto</h1>
        <form action="AlterarProdutoServlet" method="POST" >
        <label>Nome</label>
        <input type="text" name="nome" required="true" value="${produto.nome}" class="form-control"/>
        </br>
        <label>Endereço</label>
        <input type="text" name="endereco" required="true" value="${produto.endereco}" readonly="true" class="form-control"/>
        </br>
        <label>Quantidade</label>
        <input type="number" name="quantidade" required="true" value="${produto.quantidade}" class="form-control"/>
        </br>
        <button type ="submit" class="btn btn-primary">Atualizar</button>
        
        </form>
        
        <br/>         
        <a href="../POO/ProdutoServlet">Voltar</a>
    </body>
</html>
