<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="../../import.html"%>
<title>Itens mais vendidos</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<main id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Itens mais vendidos</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>Nome</td>
							<td data-orderable="false">Sabor</td>
							<td>Preço</td>
							<td>Unidades vendidas</td>
							<td>Total arrecadado</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itens}" var="item">
							<tr>
								<td data-order="${item.nome} ${item.sabor}">${item.nome}</td>
								<td>${item.sabor}</td>
								<td><fmt:formatNumber value="${item.preco}" type="currency" currencySymbol="R$" /> </td>
								<td>${item.quantidade }</td>
								<td><fmt:formatNumber value="${item.total}" type="currency" currencySymbol="R$" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<%@ include file="../../footer-template.html"%>
	<script src="/js/datatable-enable.js"></script>
</body>
</html>