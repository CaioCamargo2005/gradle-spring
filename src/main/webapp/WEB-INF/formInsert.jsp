<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resgistro</title>
    </head>
    <body>
        <h1>Novo Registro</h1>
        <form action="/insert" method="post">
            <label>Descrição</label>
            <input type ="text" name="nome" />
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>