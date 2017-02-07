<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>

    <c:url value="/webjars/bootstrap/3.3.7-1/css" var="webjarsPath" />
    <link rel="stylesheet" href="${webjarsPath}/bootstrap.css">
    <link rel="stylesheet" href="${webjarsPath}/bootstrap-theme.css">
</head>
<body>
<div class="container">
    <h1>Lista de Produtos</h1>
    <p> ${message} </p>
    <table class="table table-striped table-hover">
        <tr>
            <th>Título</th>
            <th>Descrição</th>
            <th>Páginas</th>
        </tr>

        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td><a href="${s:mvcUrl('PC#detail').arg(0,produto.id).build()}">${produto.titulo}</a></td>
                <td>${produto.descricao}</td>
                <td>${produto.paginas}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>