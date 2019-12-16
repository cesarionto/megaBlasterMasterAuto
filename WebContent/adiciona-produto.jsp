<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Adiciona Produto</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body>
	<center>
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<form action="adicionaproduto">
			<fildset> <legend>Adiciona Produto</legend>
			<p>
				Nome: <input type="text" name="nome_produto">
			</p>
			<p>
				Tipo: <input type="text" name="tipo_produto"
					placeholder="Ex: Estofamento">
			</p>
			<p>
				Detalhes: <input type="text" name="detalhes_produto">
			</p>
			<p>
				Altura: <input type="text" name="altura_produto">
			</p>
			<p>
				Largura: <input type="text" name="largura_produto">
			</p>
			<p>
				Profundidade <input type="text" name="profundidade_produto">
			</p>
			<p>
				Peso:<input type="text" name="peso_produto" placeholder="Peso em Kg">
			</p>
			<p>
				Preço na Destribuidora: <input type="text" name="preco_compra"
					placeholder="0.00">
			</p>
			<p>
				Preço na Loja: <input type="text" name="preco_venda"
					placeholder="0.00">
			</p>
			<input type="submit" value="Gravar" /> <input type="reset"
				value="Limpar" /> </fildset>
		</form>
		<br /> <br /> <a href="index.jsp">Pagina Inicial</a>
	</center>
</body>
</html>