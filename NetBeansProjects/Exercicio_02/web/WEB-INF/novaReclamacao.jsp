<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova reclamacao</title>
    </head>
    <body>
    <center>
        <h1>Nova Reclamação</h1>
        <form method="post">
            <label> Nome:
                <input type="text" name="nome"/>
            </label>
            <label>Email:
                <input type="text" name="email"/>
            </label>
            <label>Descrição:
                <input type="text" name="descricao"/>
            </label>
            <input type="submit"/>
        </form>
    </center>
</body>
</html>
