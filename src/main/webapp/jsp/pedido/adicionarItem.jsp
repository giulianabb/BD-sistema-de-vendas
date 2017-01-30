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
<title>Adicionar item ao pedido</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Adicionar item ao pedido</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form method="post" action="/pedido/${pedidoId}/salvar/item">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Item</label> <select name="item" class="form-control">
								<c:forEach items="${itens}" var="item">
									<option value="${item.id}">${item.nome} - ${item.sabor} - <fmt:formatNumber type="currency"
									currencySymbol="R$" value="${item.preco}"/>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Quantidade</label> <input type="number" name="quantidade" min="0"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Adicionar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>Observações</label> <input type="text"
								name="observacao" class="form-control">
						</div>
					</div>
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