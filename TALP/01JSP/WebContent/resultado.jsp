<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Resultado</title>
	
	<style>
		.resultado{
			width: 300px; height: 110px;background-color: #D3D3D3; border-radius: 2%; border-style: solid;
			margin-top: 8%; 
			margin-left: 40%;
		}
		.dado{
			margin-top: 10%; 
			margin-left: 35%;
			color: #228B22;
		}
		h1{
			margin-left: 47%;
		}
		a{
			margin-top: 50%; 
			margin-left: 80%;
		}
	</style>
</head>
<body>
	<h1>Resultado</h1>
	<div class = "resultado">
		<div class = "dado"><label>Resultado = ${resultado}</label><p/></div>
		
		<a href="home.html">Voltar</a>
	</div>
	
</body>
</html>