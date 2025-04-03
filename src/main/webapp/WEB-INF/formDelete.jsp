<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Delete</title>
    </head>
    <body>
        <h1>Delete</h1>
        <p>Tem certeza que deseja remover o registro: ${registros.nome} ?</p>
        <form action="/delete" method="post">
            <input type ="hidden" name="id" value="${registros.id}" />
            <button type="submit">Deletar</button>
        </form>
    </body>
</html>