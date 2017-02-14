<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Livros de Java, Android, iOS, Mobile e muito mais...">
    <div class="container middle">
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
</tags:pageTemplate>
