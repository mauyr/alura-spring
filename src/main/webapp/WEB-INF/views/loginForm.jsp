<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h1>Login Casa do Código</h1>
    <form:form servletRelativeAction="/login" method="post">
        <div class="form-group">
            <label>Nome</label>
            <input type="text" name="username" class="form-control" />
        </div>
        <div class="form-group">
            <label>Senha</label>
            <input type="password" name="password" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Logar</button>
    </form:form>
</div>
</body>
</html>