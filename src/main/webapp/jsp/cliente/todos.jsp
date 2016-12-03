<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Clientes cadastrados</title>
</head>
<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal">
		<div class="container">
			<div class="center">
				<h2>Clientes cadastrados</h2>
			</div>
			<div class="table">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome completo</td>
							<td>Torre</td>
							<td>Apartamento</td>
							<td>Telefone</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								
								<th scope="row"><a href="/cliente/editar/${cliente.id}">${cliente.id}</a></th>
								<td>${cliente.nomeCompleto}</td>
								<td>${cliente.torre}</td>
								<td>${cliente.apartamento}</td>
								<td>${cliente.telefone}</td>
								<td><a href="/cliente/deletar/${cliente.id}"><i class="fa fa-trash" aria-hidden="true"></i>
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