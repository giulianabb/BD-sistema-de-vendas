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
<title>Pedidos ativos</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal " class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Pedidos ativos</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>Nome do cliente</td>
							<td>Torre / Apartamento </td>
							<td>Data do pedido</td>
							<td>Dia da semana</td>
							<td>Cortesia</td>
							<td>Status</td>
							<td data-orderable="false"></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ativos}" var="ativo">
							<tr>
								<td>${ativo.nomeCompleto } </td>
								<td data-order="${ativo.torre}.<fmt:formatNumber minIntegerDigits="3" value="${ativo.apartamento}"/>">
									Torre ${ativo.torre} / Apt. ${ativo.apartamento}</td>
								<td data-order="<fmt:formatDate value="${ativo.data}"
										pattern="yyyyMMdd"/>">
								<fmt:formatDate value="${ativo.data}"
										pattern="dd/MM/YYYY" /></td>
								<td data-order="${ativo.diaDaSemana.ordinal()}">${ativo.diaDaSemana.toString()}</td>
								<td> ${ativo.cortesia==true? "Sim" : "Não" }</td>
								<td><form method="post" class="form-inline"
										action="/pedido/info/ativos/editar/${ativo.id}">
										<div class="form-group">
											<select name='statusNovo' class="form-control" >
												<c:forEach items="${status}" var="situacao">
													<c:choose>
													  <c:when test="${!situacao.name().equals(ativo.status.name())}">
													  	<option value="${situacao.name()}">${situacao.toString()}</option>
													  </c:when>
													  <c:otherwise>
													    <option value="${situacao.name()}" selected>${situacao.toString()}</option>
													  </c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
											<button class="btn btn-primary">Alterar status <i class="fa fa-save" aria-hidden="true"></i></button>
										</div>
									</form></td>
								<td><a
									href="/pedido/info/ativo/${ativo.id}/deletar"><i
										class="fa fa-trash" aria-hidden="true"></i> </a></td>
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