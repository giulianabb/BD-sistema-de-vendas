<%@page import="br.com.sistemavendas.type.StatusPedido"%>
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
<title>Pedidos por torre</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal " class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Pedidos por torre</h2>
			</div>
			<div class="table">
				<table class="table" id="table_simples">
					<thead>
						<tr>
							<td>Torre</td>
							<td>N�mero de pedidos realizados</td>
							<td>Valor total gasto</td>
							<td>Valor m�dio por pedido</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pedidos}" var="pedido">
							<tr>
								<td>${pedido.torre}</td>
								<td>${pedido.numPedidos}</td>
								<td><fmt:formatNumber type="currency" currencySymbol="R$" value="${pedido.valorTotal}"/>
								<td><fmt:formatNumber type="currency" currencySymbol="R$" value="${pedido.mediaPorPedido}"/>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<%@ include file="../../footer-template.html"%>
	<script src="/js/datatable-enable.js"></script>
</body>
</html>