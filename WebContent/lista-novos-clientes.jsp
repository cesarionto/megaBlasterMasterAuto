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
		<h3>Clientes</h3>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Nome:</td>
				<td>Data de Nascimento:</td>
				<td>Data de Cadastro</td>
				<td>Remover</td>
				<td>Alterar</td>
			</tr>
			<%
				
				SimpleDateFormat dataNascimento = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
				ClienteDAO dao = new ClienteDAO();
				String ano_cadastro = request.getParameter("data_cadastro");
				List<Cliente> clientes = dao.getListaNovosClientes(ano_cadastro);
				for (Cliente cliente : clientes) {
			%>
			<tr>
				<td><%=cliente.getId()%></td>
				<td><%=cliente.getNome()%></td>	
				<td><%=dataNascimento.format(cliente.getData_nascimento().getTimeInMillis())%></td>
				<td><%=dataCadastro.format(cliente.getData_cadastro().getTimeInMillis())%></td>
				<td><a href="remove-cliente.jsp?id=<%=cliente.getId()%>">
						Remover</a></td>
				<td><a href="altera-cliente.jsp?id=<%=cliente.getId()%>">
						Alterar</a></td>
				<%
					}
				%>
			</tr>
			</center>
			<a href="index.jsp">Página Inicial</a>
</body>
</html>