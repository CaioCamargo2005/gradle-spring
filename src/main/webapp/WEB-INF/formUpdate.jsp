<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edition</title>
    </head>
    <body>
        <h1>Editar Registro</h1>
        <form action="/update" method="post">
            <input type="hidden" name="id" value="${registros.id}" />
            <label>Descrição</label>
            <input type ="text" name="nome" value="${registros.nome}" />
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>