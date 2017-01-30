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
<title>Responsáveis pelo serviço</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Responsáveis pelo serviço</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form method="post" action="/pedido/${pedidoId}/servico/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<c:forEach items="${funcoes}" var="funcao">
							<div class="form-group">
								<label>${funcao.toString() } </label><select name="funcionario_${funcao.name()}" class="form-control">
									<c:forEach items="${funcionarios}" var="funcionario">
										<option value="${funcionario.id }">${funcionario.nomeCompleto}
									</c:forEach>
								</select>
							</div>
						</c:forEach>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
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