<%@ page
	import="java.util.* , br.com.cesario.mbmac.database.* ,br.com.cesario.mbmac.models.* , java.text.SimpleDateFormat"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Remove Produto</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body>
	<center>
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<%
			ProdutoDAO removedao = new ProdutoDAO();
			long id = Long.parseLong(request.getParameter("id"));
			Produto produto = new Produto();
			produto.setId(id);
			removedao.remove(produto);
			RequestDispatcher rd = request.getRequestDispatcher("/lista-produtos.jsp");
			rd.forward(request, response);
		%>
	</center> 
</body>
</html>
