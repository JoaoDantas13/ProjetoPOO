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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>

        <script type="text/javascript">
            
            function mostrarTelaConfirmacao(endereco){
                
                $("#enderecoProduto").html(endereco);
                
                var modalConfirmacao = $("#confirmarInativacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#confirmarInativacao").hide();
            }
            
            function inativarProduto(){
                var endereco = $("#enderecoProduto").html();
                fecharTelaConfirmacao();
                $.ajax("InativarProdutoServlet?endereco=" + endereco).done(function(){
                        location.reload();
                        
                    })
                    .fail(function(){
                        $("#erro").css("display", "block");
                        setTimeout(function(){
                            $("#erro").css("display", "none");                        
                        }, 3000);
                    });
            }
            
        </script>    

    </head>
    <body class="container" background="Guardian.png" bgproperties="fixed">
        <h1>Lista Produtos</h1>        

        <div class="alert alert-danger" role="alert" id="erro" style="display:none">
                Erro ao Inativar Produto!           
        </div>
        
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
                    
                    <td><a href="AlterarProdutoServlet?endereco=${produto.endereco}"><button type="button" class="btn btn-primary">Alterar</button></a></td>
                
                    <td><a href="InativarProdutoServlet?endereco=${produto.endereco}"><button type="button" class="btn btn-primary">Inativar</button></td>
                </tr>
            </c:forEach>
        </table>



        <div class="modal" id="confirmarInativacao">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Confirmar Inativação</h5>
                </div>
              <div class="modal-body">
                  <p>Tem certeza que deseja deletar o produto contido no endereço <label id="enderecoProduto"></label>?</p>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
        
                     
        <br/><br/>
   

    </body>
</html>
