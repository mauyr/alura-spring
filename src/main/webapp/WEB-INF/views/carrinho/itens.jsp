<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
<table>
    <c:forEach items="${carrinhoCompras.itens }" var="item">
        <tr>
            <td class="cart-img-col">
                <img src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145"
                     width="71px" height="100px"/>
            </td>
            <td class="item-title">${item.produto.titulo}</td>
            <td class="numeric-cell">${item.preco}</td>
            <td class="quantity-input-cell">
                <input type="number" min="0" readonly="readonly" id="quantidade" name="quantidade"
                       value="${carrinhoCompras.getQuantidade(item) }"/>
            </td>
            <td class="numeric-cell">${carrinhoCompras.getTotal(item)}</td>
            <td class="remove-item">
                <form action="${s:mvcUrl('CCC#remove').arg(0,item.produto.id).arg(1,item.tipoPreco).build()}" method="post">
                    <input type="image" src="/excluir.png" alt="Excluir" title="Excluir"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tfoot>
    <tr>
        <td colspan="3">
            <form:form action="${s:mvcUrl('PC#finalizar').build()}" method="post">
                <input type="submit" class="checkout" name="checkout" value="Finalizar compra"/>
            </form:form>
        </td>
        <td class="quantity-input-cell">
            <input type="submit" class="update-cart" disabled="disabled" name="update" value=""/>
        </td>
        <td class="numeric-cell">R$ 59,90</td>
        <td></td>
    </tr>
    </tfoot>
</table>
</body>
</html>