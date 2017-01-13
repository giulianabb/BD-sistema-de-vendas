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
<title>Todos os pedidos</title>
</head>
<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal " class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Pedidos</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>#</td>
							<td>Data do pedido</td>
							<td>Dia da semana</td>
							<td>Cortesia</td>
							<td>Meio de contato</td>
							<td>Status</td>
							<td data-orderable="false"></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="ativo">
							<tr>
								<th scope="row">${ativo.id}</th>
								<td data-order="<fmt:formatDate value="${ativo.data}"
										pattern="yyyyMMdd HH:mm" />">							
								<fmt:formatDate value="${ativo.data}"
										pattern="dd/MM/YYYY HH:mm" /></td>
								<td data-order="${ativo.diaDaSemana.ordinal()}">${ativo.diaDaSemana.toString()}</td>
								<td> ${ativo.cortesia==true? "Sim" : "Não" }</td>
								<td>${ativo.meioDeContato.toString()}</td>
								<td>${StatusPedido.qualStatus(ativo.status)}</td>
								<td>
									<form action="/pedido/info/ativo/${ativo.id}/deletar" method="post">
										<button type="submit" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
									</form>
								</td>
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