<%@ page
	import="java.util.* , br.com.cesario.mbmac.database.* ,br.com.cesario.mbmac.models.* , java.text.SimpleDateFormat"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Lista Clientes</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body> 
	<center>
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<form action="lista-novos-clientes.jsp">
			<p>Ano de Cadastro <input type="text" placeholder="Ex:2018" name="data_cadastro"/></p>
			<input type="submit" value="Pesquisar">
			<a href="index.jsp">Página Inicial</a>
		</form>
			</center>
</body>
</html> 