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
<title>Cadastrar Item</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente">
		<div class="container">
			<div class="center">
				<h2>Novo item</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form id="new-client-form" class="contact-form" name="contact-form"
					method="post" action="/item/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Nome</label> <input type="text"
								name="nome" class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Descri��o</label> <input type="text" class="form-control"
								name="descricao">
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>Sabor</label> <input type="text" name="sabor"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Pre�o</label> <input type="number"
								name="preco" class="form-control" required="required">
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