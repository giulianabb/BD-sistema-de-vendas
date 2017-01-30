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
<title>Pedido salvo</title>
</head>
<!--/head-->
<body>
	<%@ include file="../../header-template.html"%>
	<section id="home" class="page-row page-row-expanded">
		<div class="container main">
            <div class="center">        
                <h2>Pedido salvo com sucesso!</h2>
                <a class="btn btn-primary" href="/">Voltar � p�gina inicial</a>
            </div> 
        </div><!--/.container-->
	</section>
	<!--/#error-->
	<%@ include file="../../footer-template.html"%>
</body>
</html>