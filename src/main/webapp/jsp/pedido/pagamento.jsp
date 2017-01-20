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
	<section id="dados-cliente" class="page-row page-row-expanded">
		<div class="container main">
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
							<label>Valor</label> <input type="text" disabled value='<fmt:formatNumber type="currency" currencySymbol="R$" value="${precoFinal}"/>'   
								name="valorExibido" class="form-control" required="required">
								<input type="hidden" name="valor" value="${precoFinal}"/>
						</div>
						<div class="form-group">
							<label>Forma de pagamento </label><select name="tipo" id="select-tipo" class="form-control">
								<c:forEach items="${tipoPagamento}" var="tipo">
									<option value="${tipo.name()}">${tipo.toString()}
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<button type="submit" name="submit"
								class="btn btn-primary btn-lg" required="required">Salvar</button>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group" style="padding-top: 20px;">
							<label>Efetuado</label>
							 <div class="material-switch pull-right">
	                            <input id="someSwitchOptionSuccess" name="efetuado" type="checkbox" value="false"/>
	                            <label for="someSwitchOptionSuccess" class="label-success"></label>
	                        </div>
                        </div>
                        <input type="hidden" name="efetuado" value="false"/>
						<div class="form-group" id="data-pagamento" style="display: none">
							<label>Data do pagamento</label> 
							<div id="datetimepicker" class="input-append date input-group">
							    <input id="dataDesejada" type="text" name="dataPagamento" class="form-control"  value="${null}"></input>
							    <span class="add-on input-group-addon">
							      <i class="fa fa-calendar" aria-hidden="true"></i>
							    </span>
							</div>
						</div>
						<div class="pgt-dinheiro" style="display=none;">
							<div class="form-group nota-pagamento">
								<label>Nota para pagamento</label>
								<div class="input-group">
									<span class="input-group-addon">R$</span>
									<input type="text" id="dinheiro-pgt" class="form-control" data-mask="000.000.000.000.000,00" data-mask-reverse="true" >
								</div>
							</div>
							<div class="form-group troco">
								<label>Troco</label> <input id="troco" class="form-control" type="text" disabled value="">
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
	<script src="/js/bootstrap-datetimepicker.min.js"></script>
	<script src="/js/bootstrap-datetimepicker.pt-BR.js"></script>
	<script src="/js/datepicker-custom.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.pgt-dinheiro').hide();
			$('select#select-tipo').on('change', function(){
				var tipoPgt = $(this).val();
				if(tipoPgt == 'dinheiro') {
					$('.pgt-dinheiro').show();
				} else {
					$('.pgt-dinheiro').hide();
				}
			});
			
			$('input#dinheiro-pgt').on('change', function(){
				var dinheiro = $('input#dinheiro-pgt').val().replace(",", ".");
				if(!dinheiro) {
					$('input#troco').val('');
				} else {
					var pagamento = $('input[name="valor"]').val();
					var troco = parseFloat(dinheiro) - parseFloat(pagamento);
					$('input#troco').val('R$' + parseFloat(troco, 10).toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").replace("\.", ",").toString());
				}
			});
		})
	</script>
</body>
</html>