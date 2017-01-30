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
<title>Funcionários cadastrados</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Funcionários cadastrados</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>#</td>
							<td>Nome</td>
							<td data-orderable="false">CPF</td>
							<td data-orderable="false">RG</td>
							<td data-orderable="false">Endereço</td>
							<td data-orderable="false"></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${funcionarios}" var="funcionario">
							<tr>
								
								<td class="elemento-id"><a href="/funcionario/editar/${funcionario.id}">${funcionario.id}</a></td>
								<td>${funcionario.nomeCompleto}</td>
								<td data-mask="000.000.000-00">${funcionario.cpf}</td>
								<td>${funcionario.rg}</td>
								<td>${funcionario.endereco} </td>
								<td>
									<form action="/funcionario/deletar/${funcionario.id}" method="post">
										<button type="submit" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></button>
									</form>
								</td>
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