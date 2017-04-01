<%-- 
    Document   : editaVisitante
    Created on : 01/04/2017, 19:18:10
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Visitante</title>
    </head>
    <body>
        <h1>Edita Visitante</h1>
        <form method="post">
            <div><label>ID: <input type="text" name="id" value="${visitante.id}" readonly="readonly"/></label></div>
            <div><label>Nome: <input type="text" name="nome" value="${visitante.nome}"/></label></div>
            <div><label>Idade: <input type="text" name="idade" value="${visitante.idade}"/></label></div>
            <div><label>Entrada: <input type="datetime" name="entrada" value="${visitante.entrada}"/></label></div>
            <div><label>Saida: <input type="datetime" name="saida" value="${visitante.saida}"/></label></div>
            <div><input type="submit"></div>
        </form>
    </body>
</html>
