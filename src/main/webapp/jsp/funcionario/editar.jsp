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
<title>Editar funcionário</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Editar funcionário</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form class="contact-form" name="funcionario-form"
					method="post" action="/funcionario/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Nome</label> <input type="text"
								name="nomeCompleto" value="${funcionario.nomeCompleto }" class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>CPF</label> <input type="text" class="form-control" data-mask="000.000.000-00"
								name="cpf" value="${funcionario.cpf }">
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>RG</label> <input type="text" name="rg" value="${funcionario.rg }"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Endereço</label> <input type="text"
								name="endereco" value="${funcionario.endereco }" class="form-control" required="required">
						</div>
					</div>
					<input type="hidden" name="id" value="${funcionario.id}">
				</form>
					
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section>
	<%@ include file="../../footer-template.html"%>
</body>
</html>