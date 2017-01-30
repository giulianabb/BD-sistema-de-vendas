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
<title>Itens do pedido</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Pedido atual</h2>
			</div>
			<div class="table">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome</td>
							<td>Sabor</td>
							<td>Quantidade</td>
							<td>Observações</td>
							<td>Preço unitário</td>
							<td>Preço</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:set var="precoFinal" value="0"/>
						<c:forEach items="${itensPedidos}" var="itemPedido">
							<tr>
								<th scope="row"><a href="/pedido/${pedidoId}/editar/${itemPedido.id}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
</a></th>
								<td>${itemPedido.item.nome}</td>
								<td>${itemPedido.item.sabor}</td>
								<td>${itemPedido.quantidade}</td>
								<td>${itemPedido.observacao} </td>
								<td><fmt:formatNumber value="${itemPedido.item.preco}" type="currency" currencySymbol="R$" /></td>
								<td><fmt:formatNumber value="${itemPedido.item.preco * itemPedido.quantidade}" type="currency" currencySymbol="R$" />
								<c:set var="precoFinal" value="${precoFinal + itemPedido.item.preco * itemPedido.quantidade}"/> </td>
								<td>
									<form action="/pedido/${pedidoId}/deletar/item/${itemPedido.id}" method="post">
										<button type="submit" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
									</form>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="">
				<h2>Valor total: <fmt:formatNumber type="currency" value="${precoFinal}" currencySymbol="R$"/> </h2>
			</div>
			<div class="center"> 
				<a class="btn btn-primary" href="/pedido/${pedidoId}/novo/item">Adicionar item</a>
				<a class="btn btn-primary" href="/pedido/${pedidoId}/pagamento/dados">Ir para pagamento</a>
            </div><!--/.row-->
		</div>
	</section>
	<%@ include file="../../footer-template.html"%>
</body>
</html>