<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Adicionar pedido</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="dados-cliente">
		<div class="container">
			<div class="center">
				<h2>Novo pedido</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form method="post" action="/pedido/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Data do pedido</label> <input type="date"   
								name="data" class="form-control" required="required">
						</div>
						<div class="form-group">
							<label>Dia da semana </label><select name="diaDaSemana" class="form-control">
								<c:forEach items="${diasSemana}" var="dia">
									<option value="${dia.name()}">${dia.toString()}
								</c:forEach>
							</select>
						</div>
						<div class="form-group" style="padding-top: 20px;">
							<label>Cortesia</label>
							 <div class="material-switch pull-right">
	                            <input id="someSwitchOptionSuccess" name="cortesia" type="checkbox"/>
	                            <label for="someSwitchOptionSuccess" class="label-success"></label>
	                        </div>
                        </div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Adicionar itens</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>Meio de contato</label> <select name="meioDeContato" class="form-control">
								<c:forEach items="${meiosContato}" var="meio">
									<option value="${meio.name()}">${meio.toString()}
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Status do pedido</label> <select name="status" class="form-control">
								<c:forEach items="${statusPedido}" var="status">
									<option value="${status.name()}">${status.toString()}
								</c:forEach>
							</select>
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