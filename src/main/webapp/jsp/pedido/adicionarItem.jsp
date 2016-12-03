<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/font-awesome.min.css" rel="stylesheet">
<link href="../../css/prettyPhoto.css" rel="stylesheet">
<link href="../../css/animate.min.css" rel="stylesheet">
<link href="../../css/main.css" rel="stylesheet">
<link href="../../css/responsive.css" rel="stylesheet">
<script src="https://use.fontawesome.com/8b53352e30.js"></script>
<link rel="shortcut icon" href="../../images/favicon.ico">
<title>Adicionar item ao pedido</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente">
		<div class="container">
			<div class="center">
				<h2>Adicionar item ao pedido</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form method="post" action="/pedido/adicionar/item">
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
							<label>Quantidade</label> <input type="number" name="quantidade"
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
					<input type="hidden" name="pedidoId" value="${pedido.id}">
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