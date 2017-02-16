<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Livros de Java, Android, IOs, Mobile e muito mais...">
    <div class="container middle">
        <h1>Lista de Produtos</h1>
        <p> ${message} </p>
        <table class="table table-striped table-hover">
            <tr>
                <th>Título</th>
                <th>Descrição</th>
                <th>Páginas</th>
                <th>Preços</th>
            </tr>

            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><a href="${s:mvcUrl('PC#detail').arg(0,produto.id).build()}">${produto.titulo}</a></td>
                    <td>${produto.descricao}</td>
                    <td>${produto.paginas}</td>
                    <td>${produto.precos }</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</tags:pageTemplate>