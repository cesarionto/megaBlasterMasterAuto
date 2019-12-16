<%@ page
	import="java.util.* , br.com.cesario.mbmac.database.* ,br.com.cesario.mbmac.models.* , java.text.SimpleDateFormat"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Lista Produtos</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body>
	<center> 
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<h3>Produtos</h3>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Nome:</td>
				<td>Tipo:</td>
				<td>Detalhes:</td>
				<td>Altura:</td>
				<td>Largura:</td>
				<td>Profundidade:</td>
				<td>Peso:</td>
				<td>Preço no Distribuidor:</td>
				<td>Preço para Venda:</td>
				<td>Data de Cadastro no Estoque:</td>
				<td>Remover</td>
				<td>Alterar</td>
			</tr> 
			<%
				SimpleDateFormat dataNascimento = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
				ProdutoDAO dao = new ProdutoDAO();
				List<Produto> produtos = dao.getLista();
				for (Produto produto : produtos) {
			%>
			<tr>
				<td><%=produto.getId()%></td>
				<td><%=produto.getNome_produto()%></td>
				<td><%=produto.getTipo_produto()%></td>
				<td><%=produto.getDetalhes_produtos()%></td>
				<td><%=produto.getAltura_produto()%></td>
				<td><%=produto.getLargura_produto()%></td>
				<td><%=produto.getProfundidade_produto()%></td>
				<td><%=produto.getPeso_produto()%></td>
				<td><%=produto.getPreco_compra()%></td>
				<td><%=produto.getPreco_venda()%></td>
				<td><%=dataCadastro.format(produto.getData_cadastro().getTimeInMillis())%></td>
				<td><a href="remove-produto.jsp?id=<%=produto.getId()%>">
						Remover</a></td>
				<td><a href="altera-produto.jsp?id=<%=produto.getId()%>">
						Alterar</a></td>
				<%
					}
				%>
			</tr>
			</center>
			<a href="index.jsp">Página Inicial</a>
</body>
</html>