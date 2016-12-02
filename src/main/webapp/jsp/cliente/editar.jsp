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
<title>Cadastrar cliente</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente">
		<div class="container">
			<div class="center">
				<h2>Editar cliente</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form id="new-client-form" class="contact-form" name="contact-form"
					method="post" action="/cliente/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Nome completo</label> <input type="text"
								name="nomeCompleto" value="${cliente.nomeCompleto}"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Telefone</label> <input type="number" class="form-control"
								name="telefone" value="${cliente.telefone}">
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>Torre</label> <input type="number" name="torre"
								value="${cliente.torre}" class="form-control"
								required="required">
						</div>
						<div class="form-group">
							<label>Apartamento</label> <input type="number"
								name="apartamento" value="${cliente.apartamento}"
								class="form-control" required="required">
						</div>
						<input type="hidden" name="id" value="${cliente.id}">
					</div>
				</form>
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
	</section>
	<%@ include file="../../footer-template.html"%>
</body>
</html>