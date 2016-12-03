<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Funcionário cadastrado</title>
</head><!--/head-->

<body>
	<%@ include file="../../header-template.html" %>
    <section id="principal">
        <div class="container">
            <div class="center">        
                <h2>Funcionário gravado com sucesso!</h2>
            </div> 
            <div class="container text-center"> 
				<a class="btn btn-primary" href="/">Voltar à página inicial</a>
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#contact-page-->
	<%@ include file="../../footer-template.html" %>
</body>
</html>