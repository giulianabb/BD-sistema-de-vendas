<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Pagamento</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section>
		<div class="container">
			<div class="center">
				<h2>Pagamento</h2>
			</div>
			<div class="row contact-wrap">
				<div class="status alert alert-success" style="display: none"></div>
				<form method="post" action="/pedido/${pedidoId}/pagamento/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Cliente </label><select name="clienteId" class="form-control">
								<c:forEach items="${clientes}" var="cliente">
									<option value="${cliente.id }">${cliente.nomeCompleto} - Torre ${cliente.torre} - Apt. ${cliente.apartamento }
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Forma de pagamento </label><select name="tipo" class="form-control">
								<c:forEach items="${tipoPagamento}" var="tipo">
									<option value="${tipo.name()}">${tipo.toString()}
								</c:forEach>
							</select>
							
						</div>
						<div class="form-group">
							<label>Valor</label> <input type="text" disabled value='<fmt:formatNumber type="currency" currencySymbol="R$" value="${precoFinal}"/>'   
								name="valorExibido" class="form-control" required="required">
								<input type="hidden" name="valor" value="${precoFinal}"/>
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label>Data do pagamento</label> <input type="date"   
								name="dataPagamento" class="form-control" required="required">
						</div>
						<div class="form-group" style="padding-top: 20px;">
							<label>Efetuado</label>
							 <div class="material-switch pull-right">
	                            <input id="someSwitchOptionSuccess" name="efetuado" type="checkbox"/>
	                            <label for="someSwitchOptionSuccess" class="label-success"></label>
	                        </div>
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