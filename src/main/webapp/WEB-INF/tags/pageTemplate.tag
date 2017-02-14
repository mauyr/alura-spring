<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="titulo" required="true" %>
<%@ attribute name="bodyClass" required="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <title>${produto.titulo} - Casa do Código</title>

    <c:url value="/webjars/bootstrap/3.3.7-1/css" var="webjarsPath" />
    <link rel="stylesheet" href="${webjarsPath}/bootstrap.css">
    <link rel="stylesheet" href="${webjarsPath}/bootstrap-theme.css">
</head>
<body class="${bodyClass}">
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>

<jsp:doBody />

<%@ include file="/WEB-INF/views/rodape.jsp" %>
</body>
</html>