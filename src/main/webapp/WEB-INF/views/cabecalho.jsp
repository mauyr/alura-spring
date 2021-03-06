<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="${s:mvcUrl('PC#list').build()}">Lista de Produtos</a></li>
                    <li><a href="${s:mvcUrl('PC#edit').build()}">Cadastro de Produtos</a></li>
                </security:authorize>

                <li><a href="${s:mvcUrl('CCC#itens').build()}" rel="nofollow">
                    <s:message code="menu.carrinho" arguments="${carrinhoCompras.quantidade}" />
                </a></li>
                <li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">
                    <s:message code="menu.sobre" />
                </a></li>

                <li>
                    <a href="?locale=pt" rel="nofollow">
                        <fmt:message key="menu.pt"/>
                    </a>
                </li>

                <li>
                    <a href="?locale=en_US" rel="nofollow">
                        <fmt:message key="menu.en"/>
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <security:authentication property="principal" var="usuario"/>
                        Usuário:
                    </a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>