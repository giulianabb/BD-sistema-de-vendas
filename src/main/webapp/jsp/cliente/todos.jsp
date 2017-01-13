<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Clientes cadastrados</title>
</head>
<body>
	<%@ include file="../../header-template.html"%>
	<main id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Clientes cadastrados</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome completo</td>
							<td>Torre / Apartamento</td>
							<td data-orderable="false">Telefone</td>
							<td data-orderable="false"></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td class="cliente-id"><a href="/cliente/editar/${cliente.id}">${cliente.id}</a></td>
								<td>${cliente.nomeCompleto}</td>
								<td data-order="${cliente.torre}.<fmt:formatNumber minIntegerDigits="3" value="${cliente.apartamento}"/>">
								Torre ${cliente.torre} / Apt. ${cliente.apartamento}</td>
								<td>${cliente.telefone}</td>
								<td><a href="/cliente/deletar/${cliente.id}"><i class="fa fa-trash" aria-hidden="true"></i>
								</a></td>
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