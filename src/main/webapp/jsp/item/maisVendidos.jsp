<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="../../import.html"%>
<title>Itens mais vendidos</title>
</head>
<!--/head-->

<body>
	<%@ include file="../../header-template.html"%>
	<main id="principal" class="page-row page-row-expanded">
		<div class="container main">
			<div class="center">
				<h2>Itens mais vendidos</h2>
			</div>
			<div class="table">
				<table class="table" id="table_todos">
					<thead>
						<tr>
							<td>Nome</td>
							<td data-orderable="false">Sabor</td>
							<td>Preço</td>
							<td>Unidades vendidas</td>
							<td>Total arrecadado</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itens}" var="item">
							<tr>
								<td data-order="${item.nome} ${item.sabor}">${item.nome}</td>
								<td>${item.sabor}</td>
								<td><fmt:formatNumber value="${item.preco}" type="currency" currencySymbol="R$" /> </td>
								<td>${item.quantidade }</td>
								<td><fmt:formatNumber value="${item.total}" type="currency" currencySymbol="R$" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="charts">
				<div class="chart">
					<canvas id="chartMaisVendidosPorUnidade" width="750" height="500"></canvas>
				</div>
				<div class="chart">
					<canvas id="chartMaisVendidosPorValor" width="750" height="500"></canvas>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../../footer-template.html"%>
	<script src="/js/datatable-enable.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.bundle.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var itens = [
				<c:forEach items="${itens}" var="item" varStatus="status">
					'${item.nome} (${item.sabor})'<c:if test="${!status.last}">, </c:if>  
			    </c:forEach>
			];
			
			var quantidade = [
				<c:forEach items="${itens}" var="item" varStatus="status">
					'${item.quantidade}' <c:if test="${!status.last}">, </c:if>  
  		        </c:forEach>
			];
			
			var valorArrecadado = [
				<c:forEach items="${itens}" var="item" varStatus="status">
					'${item.total}' <c:if test="${!status.last}">, </c:if>  
		        </c:forEach>
			];
			
			var ctxUn = $('#chartMaisVendidosPorUnidade');
			var myChartUnidades = new Chart(ctxUn, {
				type: 'bar',
			    data: {
			        labels: itens,
			        datasets: [{
			        	label: 'Unidades vendidas',
			            data: quantidade,
			            backgroundColor: 'rgba(255, 99, 132, 0.2)',
			            borderColor: 'rgba(255,99,132,1)',
			            borderWidth: 1
			        }]
			    },
			    options: {
			    	responsive: false,
			        scales: {
			          yAxes: [{
			            ticks: {
			              beginAtZero:true
			            }
			          }]
			       }
			    }
			});
			
			var ctxVal = $('#chartMaisVendidosPorValor');
			var myChartValor = new Chart(ctxVal, {
				type: 'bar',
			    data: {
			        labels: itens,
			        datasets: [{
			        	label: 'Total arrecadado',
			            data: valorArrecadado,
			            backgroundColor: 'rgba(10, 240, 0, 0.1)',
			            borderColor: 'rgba(82, 172, 57, 1)',
			            borderWidth: 1
			        }]
			    },
			    options: {
			    	responsive: false,
			        scales: {
			            yAxes: [{
			                ticks: {
			                    beginAtZero:true
			                }
			            }]
			        }
			    }
			});
		});
	</script>
</body>
</html>