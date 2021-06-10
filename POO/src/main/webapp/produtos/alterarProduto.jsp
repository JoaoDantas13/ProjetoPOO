<%-- 
    Document   : alterarProduto
    Created on : 6 de jun. de 2021, 13:20:25
    Author     : HOME
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">                
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardian</title>
    </head>
    <body class="container" background="Guardian.png" bgproperties="fixed">
        <h1>Baixar Produto</h1>
        <form action="AlterarProdutoServlet" method="POST" >
        <label>Nome</label>
        <input type="text" name="nome" required="true" value="${produto.nome}" readonly="true" class="form-control"/>
        </br>
        <label>Endereço</label>
        <input type="text" name="endereco" required="true" value="${produto.endereco}" readonly="true" class="form-control"/>
        </br>
        <label>Métrica</label>
        <input type="text" name="metrica" required="true" value="${produto.metrica}" readonly="true" class="form-control"/>
        </br>
        <label>Quantidade</label>
        
        <c:set var = "metricax" value = "${produto.metrica}"/>
                    
                    <c:if test="${metricax == 'unidade'}">
                        <input type="number" name="quantidade" required="true" value="${produto.unidades}" class="form-control"/>
                    </c:if>
                    
                    <c:if test="${metricax == 'm2'}">
                        <input type="number" name="quantidade" required="true" value="${produto.m2}" class="form-control"/>
                    </c:if> 
                    
                    <c:if test="${metricax == 'm3'}">
                        <input type="number" name="quantidade" required="true" value="${produto.m3}" class="form-control"/>
                    </c:if>        
        
        
        </br>
        <button type ="submit" class="btn btn-primary">Atualizar</button>
        
        </form>
        
        <br/>         
        <a href="../POO/ProdutoServlet">Voltar</a>
    </body>
</html>
