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
<title>Itens cadastrados</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal">
		<div class="container">
			<div class="center">
				<h2>Itens cadastrados</h2>
			</div>
			<div class="table">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome</td>
							<td>Descrição</td>
							<td>Sabor</td>
							<td>Preço</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itens}" var="item">
							<tr>
								
								<th scope="row"><a href="/item/editar/${item.id}">${item.id}</a></th>
								<td>${item.nome}</td>
								<td>${item.descricao}</td>
								<td>${item.sabor}</td>
								<td><fmt:formatNumber value="${item.preco}" type="currency" currencySymbol="R$" /> </td>
								<td><a href="/item/deletar/${item.id}"><i class="fa fa-trash" aria-hidden="true"></i>
								</a></td>
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