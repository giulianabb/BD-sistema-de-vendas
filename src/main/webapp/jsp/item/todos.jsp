<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Itens cadastrados</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<main id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Itens cadastrados</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome</td>
							<td data-orderable="false">Sabor</td>
							<td data-orderable="false">Descrição</td>
							<td>Preço</td>
							<td data-orderable="false"></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itens}" var="item">
							<tr>
								
								<td class="elemento-id"><a href="/item/editar/${item.id}">${item.id}</a></td>
								<td data-order="${item.nome} ${item.sabor}">${item.nome}</td>
								<td>${item.sabor}</td>
								<td>${item.descricao}</td>
								<td><fmt:formatNumber value="${item.preco}" type="currency" currencySymbol="R$" /> </td>
								<td>
									<form action="/item/deletar/${item.id}" method="post">
										<button type="submit" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
									</form>
								</td>
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