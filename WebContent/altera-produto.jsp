<%@ page
	import="java.util.*, java.util.Date , java.text.SimpleDateFormat, br.com.cesario.mbmac.database.*, 
br.com.cesario.mbmac.models.*"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Adiciona Produto</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body>
	<% 
		SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.getProdutoById(request.getParameter("id"));
	%>
	<center>
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<form action="alteraproduto">
			<fildset> <legend>Altera Produto</legend>
			<p>
				id: <input type="text" name="id" readonly="readonly" value="<%=produto.getId()%>">
			</p>
			<p>
				Nome: <input type="text" name="nome_produto"
					value="<%=produto.getNome_produto()%>">
			</p>
			<p>
				Tipo: <input type="text" name="tipo_produto"
					placeholder="Ex: Estofamento"
					value="<%=produto.getTipo_produto()%>">
			</p>
			<p>
				Detalhes: <input type="text" name="detalhes_produto"
					value="<%=produto.getDetalhes_produtos()%>">
			</p>
			<p>
				Altura: <input type="text" name="altura_produto" value="<%=produto.getAltura_produto()%>">
			</p>
			<p>
				Largura: <input type="text" name="largura_produto"
					value="<%=produto.getLargura_produto()%>">
			</p>
			<p>
				Profundidade <input type="text" name="profundidade_produto"
					value="<%=produto.getProfundidade_produto()%>">
			</p>
			<p>
				Peso:<input type="text" name="peso_produto" placeholder="Peso em Kg"
					value="<%=produto.getPeso_produto()%>">
			</p>
			<p>
				Preço na Destribuidora: <input type="text" name="preco_compra"
					placeholder="0.00" value="<%=produto.getPreco_compra()%>">
			</p>
			<p>
				Preço na Loja: <input type="text" name="preco_venda"
					placeholder="0.00" value="<%=produto.getPreco_venda()%>">
			</p>
			<p>
				Data de Cadastro: <input type="text" readonly="readonly" name="data_cadastro"
					placeholder="xx/xx/xxxx"
					value="<%=data_formatada.format(produto.getData_cadastro().getTime())%>">
			</p>
			<input type="submit" value="Gravar" /> <input type="reset"
				value="Limpar" /> </fildset>
		</form>
		<br /> <br /> <a href="index.jsp">Pagina Inicial</a>
	</center>
</body>
</html>