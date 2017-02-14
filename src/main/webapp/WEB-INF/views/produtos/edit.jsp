<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Livros de Java, Android, IOs, Mobile e muito mais...">

    <form:form action="${s:mvcUrl('PC#create').build()}" method="post" commandName="produto" enctype="multipart/form-data">
        <div>
            <label>Título</label>
            <form:input path="titulo"/>
            <form:errors path="titulo" />
        </div>
        <div>
            <label>Descrição</label>
            <form:textarea rows="10" cols="20" path="descricao"/>
            <form:errors path="descricao" />
        </div>
        <div>
            <label>Páginas</label>
            <form:input path="paginas"/>
            <form:errors path="paginas" />
        </div>

        <div>
            <label>Data de Lançamento</label>
            <form:input path="dataLancamento" />
            <form:errors path="dataLancamento" />
        </div>

        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label>
            <form:input path="precos[${status.index}].valor" />
            <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
        </c:forEach>

        <div>
            <label>Imagem da Capa</label>
            <input name="imagemCapa" type="file" />
        </div>

        <button type="submit">Cadastrar</button>
    </form:form>
</tags:pageTemplate>