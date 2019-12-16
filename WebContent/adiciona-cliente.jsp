<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Adiciona Cliente</title>
<link rel="icon" type="image/png" href="logo.png" />
</head>
<body>
	<center>
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" /> <br /> <br />
		<form action="adicionacliente">
			<fildset> <legend>Adiciona Cliente</legend>
			<p>
				Nome: <input type="text" name="nome" placeholder="Nome Completo">
			</p>
			<p>
				CPF: <input type="text" name="cpf" placeholder="Somente Numeros">
			</p>
			<p>
				RG: <input type="text" name="rg" placeholder="Somente Numeros">
			</p>
			<p>
				Data de Nascimento: <input type="text" name="data_nascimento"
					placeholder="dd/mm/aaaa">
			</p>
			<p>
				Nome da Mae: <input type="text" name="nomeMae">
			</p>
			<p>
				Telefone Celular: <input type="text" name="telefone_celular"
					placeholder="(DDD) XXXXX-XXXX">
			</p>
			<p>
				E-Mail: <input type="text" name="email"
					placeholder="email@email.com">
			</p>
			<p>
				Estado: <input type="text" name="estado" placeholder="Ex: RN">
			</p>
			<p>
				Cidade: <input type="text" name="cidade">
			</p>
			<p>
				Bairro: <input type="text" name="bairro">
			</p>
			<p>
				Rua: <input type="text" name="rua">
			</p>
			<p>
				CEP: <input type="text" name="cep" placeholder="Somente Numeros">
			</p>
			<p>
				N° da Casa: <input type="text" name="numeroCasa">
			</p>
			<input type="submit" value="Gravar" /> <input type="reset"
				value="Limpar" /> </fildset>
		</form>
		<br /> <br /> <a href="index.jsp">Pagina Inicial</a>
	</center>
</body>
</html>