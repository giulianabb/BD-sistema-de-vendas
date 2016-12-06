<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Editar item</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Editar item</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form method="post" action="/pedido/${pedidoId}/salvar/item">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Item</label> <select name="item" class="form-control">
								<c:forEach items="${itens}" var="item">
									<c:choose>
										<c:when test="${item.id == itemPedido.item.id}">
											<option selected="selected" value="${item.id}">${item.nome} - ${item.sabor} - <fmt:formatNumber type="currency"
										currencySymbol="R$" value="${item.preco}"/>
										</c:when>
										<c:otherwise>
											<option value="${item.id}">${item.nome} - ${item.sabor} - <fmt:formatNumber type="currency"
										currencySymbol="R$" value="${item.preco}"/>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Quantidade</label> <input type="number" name="quantidade" value="${itemPedido.quantidade}"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>Observações</label> <input type="text" value="${itemPedido.observacao}"
								name="observacao" class="form-control">
						</div>
					</div>
					<input name="id" value="${itemPedido.id}" type="hidden"/>
				</form>
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section>
	<!--/#contact-page-->
	<%@ include file="../../footer-template.html"%>

</body>
</html>