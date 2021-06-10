<%-- 
    Document   : incluirProduto
    Created on : 9 de jun. de 2021, 19:00:15
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
        <h1>Produto</h1>
        
        <form action="../CadastrarProdutoServlet" method="POST">
        <label class="form-label">Nome</label>
        <input type="text" name="nome" required="true" class="form-control" placeholder="Ex.: Areia, Martelo, Porcelanato"/>
        </br>
        <label class="form-label">Endereço</label>
        <input type="text" name="endereco" required="true" class="form-control" placeholder="Ex.: A2, G34, R45"/>
        </br>
        
        <label class="form-label">Métrica</label>
        </br>
        
        <select name="metrica" class="form-control" required="true">
            <option value="">Selecione uma Métrica</option>
            <option value="unidade">Unidade</option>
            <option value="m2">m²</option>
            <option value="m3">m³</option>            
        </select>

        </br>
        
        <label class="form-label">Quantidade</label>
        <input type = "number" name="quantidade" required="true" class="form-control"/><br>
        
        <button type ="submit" class="btn btn-primary">Incluir</button>
        
        </form>

                   
        <br/><br/>        
        
        
        
        <br/>         
        <a href="../ProdutoServlet">Voltar</a>
    </body>
</html>
