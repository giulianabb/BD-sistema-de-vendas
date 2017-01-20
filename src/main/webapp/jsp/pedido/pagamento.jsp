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
			<div class="row">
				<div class="pull-right btn-novo-cliente">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-cliente-novo" style="margin-left: 15px;">
									<label><i class="fa fa-plus" aria-hidden="true"></i> Adicione um novo cliente</label>
					</button>
				</div>
			</div>	
			<div class="row contact-wrap">
				<form method="post" action="/pedido/${pedidoId}/pagamento/salvar">
					<div class="col-sm-5 col-sm-offset-1">
						<div class="form-group">
							<label>Cliente</label>
								<select name="clienteId" class="form-control" id="select-cliente">
									<c:forEach items="${clientes}" var="cliente">
										<option value="${cliente.id }">${cliente.nomeCompleto} - Torre ${cliente.torre} - Apt. ${cliente.apartamento}
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
								<label>Valor do pagamento</label>
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
		</div>
		<!--/.container-->
		<!-- Modal -->
		<div class="modal fade" id="modal-cliente-novo" tabindex="-1" role="dialog" aria-labelledby="modal-cliente-novo">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h2 class="modal-title" id="myModalLabel">Novo cliente</h2>
					</div>
					<div class="modal-body">
						<form id="new-client-form" class="contact-form" name="contact-form"
							method="post" action="/cliente/ajax/salvar">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Nome completo</label> <input type="text"
										name="nomeCompleto" class="form-control" required="required">
								</div>
								<div class="form-group">
									<label>Telefone</label> <input type="text" class="form-control sp_celphones"
										name="telefone">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Torre</label> <input type="number" name="torre" min="1" max="10"
										class="form-control" required="required">
								</div>
								<div class="form-group">
									<label>Apartamento</label> <input type="number" min="11" max="266"
										name="apartamento" class="form-control" required="required">
								</div>
							</div>
							<div class="form-group" align="right">
						        <button type="submit" class="btn btn-primary" id="salvar-novo-cliente">Salvar</button>
				        	</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#contact-page-->
	<%@ include file="../../footer-template.html"%>
	<script src="/js/bootstrap-datetimepicker.min.js"></script>
	<script src="/js/bootstrap-datetimepicker.pt-BR.js"></script>
	<script src="/js/datepicker-custom.js"></script>
	<script type="text/javascript">
		jQuery.noConflict();
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
			
			$('#new-client-form').on('submit', function(event){
				event.preventDefault();
				var $form = $(this),
					url = $form.attr('action');
				
				var posting = $.post(url, $form.serialize())
				
				posting.done(function(data) {
					var cliente = data;
					$('#select-cliente').append($('<option selected value="' + cliente.id + '">' + cliente.nomeCompleto +
							' - Torre ' + cliente.torre + ' - Apt. ' + cliente.apartamento + '</option>'));
					$('#modal-cliente-novo').modal('hide');
				})
				
				posting.fail(function(){
					$('.modal-body').prepend('<div class="alert alert-danger" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>Ocorreu um erro!</div>');
				})
				
			});
		})
	</script>
</body>
</html>