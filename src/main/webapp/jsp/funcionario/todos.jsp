<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Funcionários cadastrados</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal">
		<div class="container">
			<div class="center">
				<h2>Funcionários cadastrados</h2>
			</div>
			<div class="table">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome</td>
							<td>CPF</td>
							<td>RG</td>
							<td>Endereço</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${funcionarios}" var="funcionario">
							<tr>
								
								<th scope="row"><a href="/funcionario/editar/${funcionario.id}">${funcionario.id}</a></th>
								<td>${funcionario.nomeCompleto}</td>
								<td>${funcionario.cpf}</td>
								<td>${funcionario.rg}</td>
								<td>${funcionario.endereco} </td>
								<td><a href="/funcionario/deletar/${funcionario.id}"><i class="fa fa-trash" aria-hidden="true"></i>
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