<%@ page
	import="java.util.* , br.com.cesario.mbmac.database.* ,br.com.cesario.mbmac.models.* , java.text.SimpleDateFormat"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Remove Cliente</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body> 
	<center>
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<%
			ClienteDAO dao = new ClienteDAO();
			long id = Long.parseLong(request.getParameter("id"));
			Cliente cliente = new Cliente();
			cliente.setId(id);
			dao.remove(cliente);
			RequestDispatcher rd = request.getRequestDispatcher("/lista-clientes.jsp");
			rd.forward(request, response);
		%>
		<p>Contato Removido com Sucesso!</p>
		<br>
		<p>
			<a href="index.jsp">Home</a>
		</p>
	</center> 
</body>
</html>
