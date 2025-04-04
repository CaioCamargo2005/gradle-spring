<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>List</title>
    </head>
    <body>
        <h1>Registros de Gêneros</h1>
        <a href="/generos/insert">Novo Registro</a>
        <ul>
            <c:forEach var="item" items="${registros}">
                <li>${item.nome}</li> | 
                <a href="/update?id=${item.id}">Editar</a> | 
                <a href="/delete?id=${item.id}">Deletar</a>
            </c:forEach>
        </ul>
    </body>
</html>