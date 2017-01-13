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
<title>Pedidos não pagos</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal " class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Pedidos não pagos</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>Cliente</td>
							<td>Torre/Apartamento</td>
							<td>Data do pedido</td>
							<td>Cortesia</td>
							<td>Valor</td>
							<td>Efetuado</td>
							<td data-orderable="false"></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${naoPagos}" var="solicitacao">
							<tr>
								<td>${solicitacao.cliente.nomeCompleto}</td>
								<td data-order="${solicitacao.cliente.torre}.<fmt:formatNumber minIntegerDigits="3" value="${solicitacao.cliente.apartamento}"/>">
									Torre ${solicitacao.cliente.torre} / Apt. ${solicitacao.cliente.apartamento} </td>
								<td><fmt:formatDate value="${solicitacao.pedido.data}"
										pattern="dd/MM/YYYY hh:mm" /></td>
								<td> ${solicitacao.pedido.cortesia==true? "Sim" : "Não" }</td>
								<td><fmt:formatNumber type="currency" currencySymbol="R$" value="${solicitacao.pagamento.valor}"/>
								<td> ${solicitacao.pagamento.efetuado==true? "Sim" : "Não" }</td>
								<td>
									<form method="post" style="margin-top: -10px" action="/pedido/info/nao-pagos/editar/${solicitacao.pagamento.id}">
										<div class="form-group">
											<div class="form-group">
												<button class="btn btn-primary">Pagamento realizado   
												<i class="fa fa-check" aria-hidden="true"></i></button>
											</div>
										</div>
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