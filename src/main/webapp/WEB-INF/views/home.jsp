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
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Casa do Código</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${s:mvcUrl('PC#list').build()}">Lista de Produtos</a></li>
                <li><a href="${s:mvcUrl('PC#edit').build()}">Cadastro de Produtos</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>

<div class="container">
    <c:forEach items="${produtos}" var="produto">

    <li>
        <a href="${s:mvcUrl('PC#detail').arg(0, produto.id).build()}" class="block clearfix">
            <h2 class="product-title">${produto.titulo}</h2>
            <img width="143"
                 height="202"
                 src="https://cdn.shopify.com/s/files/1/0155/7645/products/java8-featured_large.png?v=1411490181"
                 alt="Java 8 Prático"
                 title="Java 8 Prático"/>
            <small class="buy-button">Compre</small>
        </a>
    </li>
    </c:forEach>
</div>
</html>