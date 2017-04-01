<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Visitantes</title>
    </head>
    <body>
    <center>
        <h1>Lista de Visitantes</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Idade</th>
                <th>Entrada</th>
                <th>Saida</th>
            </tr>
            <c:forEach var="visitante" items="${visitante}">
                <tr>
                    <td><a href ="edita.html?id=${visitante.id}">${visitante.id}</a></td>
                    <td>${visitante.nome}</td>
                    <td>${visitante.idade}</td>
                    <td>${visitante.entrada}</td>
                    <td>${visitante.saida}</td>
                    <td><a href="exclui.html?id=${visitante.id}"><img src="Icones/exclui.jpg" width="20" height="20"></a></td>
                </tr>
            </c:forEach>
        </table>
    </center>
    </body>
</html>
