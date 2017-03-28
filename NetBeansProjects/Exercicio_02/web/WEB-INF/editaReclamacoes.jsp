<%-- 
    Document   : editaregistro
    Created on : 10/03/2017, 21:58:56
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Reclamacao</title>
    </head>
    <body>
    <center>
        <h1>Edita Reclamacao</h1>
        <form method="post">
            <div><input type="hidden" name="id" value="${reclamacao.id}"/></div>
            <div><label>Nome: <input type="text" name="nome" value="${reclamacao.nome}"/> </label></div>
            <div><label>Email: <input type="text" name="email" value="${reclamacao.email}"/> </label></div>
            <div><label>Descrição: <textarea name="descricao" rows="4" cols="20" >${reclamacao.descricao}</textarea></label></div>
            <div><label>Status: <select name="status" >
                <option value="0">Aberto</option>
                <option value="1">Confirmado</option>
                <option value="2">Recusado</option>
                <option value="3">Em Execução</option>
                <option value="4">Resolvido</option>
            </select></label></div>
            <div><input type="submit"/></div>
        </form>
    </center>
    </body>
</html>
