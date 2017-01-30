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
<title>Histórico de pedidos</title>
</head>
<body>
	<%@ include file="../../header-template.html"%>
	<main id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Histórico de pedidos</h2>
			<c:choose>
			<c:when test="${historico == null}">
					<p>Não existem pedidos anteriores para este cliente!</p>
					<a href="/cliente/todos"  class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>
				</div>
			</c:when>
			<c:otherwise>
					<h3>${historico.cliente.nomeCompleto} - Torre ${historico.cliente.torre}/ Apt. ${historico.cliente.apartamento}</h3>
					<a href="/cliente/todos" class="btn btn-primary"><i class="fa fa-arrow-left" aria-hidden="true"></i> Voltar</a>
				</div>
				<div class="table">
					<table class="table" id="table_todos">
						<thead>
							<tr>
								<td>Data do pedido</td>
								<td>Dia da semana</td>
								<td data-orderable="false">Itens do pedido</td>
								<td>Valor final</td>
								<td>Forma de pagamento</td>
								<td>Meio de contato</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${historico.solicitacoes}" var="solicitacao" varStatus="solicitacaoLoop">
								<tr>
									<td data-order="<fmt:formatDate value="${solicitacao.pedido.data}" pattern="yyyyMMdd HH:mm"/>">
										<fmt:formatDate value="${solicitacao.pedido.data}" pattern="dd/MM/yyyy HH:mm"/>
									</td>
									<td data-order="${solicitacao.pedido.diaDaSemana.ordinal()}">${solicitacao.pedido.diaDaSemana.toString()}</td>
									<td>
										<ul class="list-unstyled">
										<c:forEach items="${historico.itensPorPedido.get(solicitacao.pedido.id)}" var="itemPedido">
											<li class="item-pedidos-historico">
												${itemPedido.quantidade} ${itemPedido.item.nome}
											</li>
										</c:forEach>
										</ul>
									</td>
									<td><fmt:formatNumber type="currency" value="${solicitacao.pagamento.valor}" currencySymbol="R$" /></td>
									<td>${solicitacao.pagamento.tipo.toString()}</td>
									<td>${solicitacao.pedido.meioDeContato.toString()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
			</c:choose>
		</div>
	</main>
	<%@ include file="../../footer-template.html"%>
	<script src="/js/datatable-enable.js"></script>
</body>
</html>