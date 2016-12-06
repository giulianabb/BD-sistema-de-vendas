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
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>Data do pedido</td>
							<td>Dia da semana</td>
							<td>Cortesia</td>
							<td>Meio de contato</td>
							<td>Status</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ativos}" var="ativo">
							<tr>
								<th scope="row">${ativo.id}</th>
								<td><fmt:formatDate value="${ativo.data}"
										pattern="dd/MM/YYYY hh:mm" /></td>
								<td>${ativo.diaDaSemana.toString()}</td>
								<td> ${ativo.cortesia==true? "Sim" : "Não" }</td>
								<td>${ativo.meioDeContato.toString()}</td>
								<td><form method="post"
										action="/pedido/info/ativos/editar/${ativo.id}">
										<div class="form-group">
											<select name='statusNovo' class="form-control" >
												<c:forEach items="${status}" var="situacao">
													<c:choose>
													  <c:when test="${!situacao.name().equals(ativo.status)}">
													  	<option value="${situacao.name()}">${situacao.toString()}</option>
													  </c:when>
													  <c:otherwise>
													    <option value="${situacao.name()}" selected>${situacao.toString()}</option>
													  </c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
											<div class="form-group">
												<button class="btn btn-primary">Alterar status <i
										class="fa fa-save" aria-hidden="true"></i></button>
											</div>
										</div>
									</form></td>
								<td><a
									href="/pedido/info/ativos/${ativo.id}/deletar"><i
										class="fa fa-trash" aria-hidden="true"></i> </a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<%@ include file="../../footer-template.html"%>
</body>
</html>