<%@page import="br.com.sistemavendas.type.StatusPedido"%>
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
<title>Fechamento do dia</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<section id="principal " class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Fechamento do dia</h2>
				<div class="pull-right">
					<form action="/pedido/info/fechamento/dia" method="get" id="form-dia">
						<div id="datetimepicker2" class="input-append date input-group">
							<input id="dataDesejada" type="text" name="dia"
								class="form-control" value="<fmt:formatDate value="${dia}" pattern="dd/MM/yyyy"/>"></input> <span
								class="add-on input-group-addon"> <i class="fa fa-calendar"
								aria-hidden="true"></i> 
							</span>
						</div>
					</form>
				</div>
			</div>
			<div class="table">
				<table class="table" id="table_simples">
					<thead>
						<tr>
							<td>Item</td>
							<td>Quantidade</td>
							<td>Valor total</td>
							<td>Responsável</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itensPedidos}" var="item">
							<tr>
								<td>${item.nome}</td>
								<td>${item.quantidade}</td>
								<td><fmt:formatNumber type="currency" currencySymbol="R$" value="${item.total}"/></td>
								<td>${item.funcionario == null? " - " : item.funcionario.nome }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 
			
			**** TOTAL POR FUNCIONARIO ****
			
			<div class="table">
				<table class="table">
					<thead>
						<tr>
							<td>Funcionário</td>
							<td>Total</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itensPedidos}" var="item">
							<tr>
								<td>${item.nome}</td>
								<td>${item.quantidade}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			 -->
		</div>
	</section>
	<%@ include file="../../footer-template.html"%>
	<script src="/js/datatable-enable.js"></script>
	<script src="/js/bootstrap-datetimepicker.min.js"></script>
	<script src="/js/bootstrap-datetimepicker.pt-BR.js"></script>
	<script>
		$(document).ready(function(){
			$('#datetimepicker2').datetimepicker({
		        format: 'dd/MM/yyyy',
		        pickDate: true,
		        pickTime: false,
		        language: 'pt-BR'
		      }).on('changeDate', buscaFechamentoDoDia);
			
			configuraParametrosIniciais();
			
			function buscaFechamentoDoDia() {
				$('#form-dia').submit();
			}
			
			function configuraParametrosIniciais() {
				var diaAtual = $('#dataDesejada').val();
				if(diaAtual == "") {
					diaAtual = new Date();
				}
				$('#datetimepicker2').data('datetimepicker').setLocalDate(diaAtual);
			}
		});
	</script>
</body>
</html>