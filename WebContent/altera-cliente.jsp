<%@ page import = "java.util.*, java.util.Date , java.text.SimpleDateFormat, br.com.cesario.mbmac.database.*, br.com.cesario.mbmac.models.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mega Blaster Master Auto - Altera Cliente</title>
<link rel="icon" 
      type="image/png" 
      href="logo.png" />
</head> 
<body>
<% 
	SimpleDateFormat data_formatada = new SimpleDateFormat("dd/MM/yyyy");
	ClienteDAO dao = new ClienteDAO();
	Cliente cliente = dao.getClienteById(request.getParameter("id"));
%>
	<center> 
		<h1>Mega Blaster Master Auto</h1>
		<img src="logo.png" alt="logo" height="200" width="300" />
		<br/>
		<br/>
		<form action="alteracliente">
			<fildset>
				<legend>Altera Cliente</legend>
				<p>Id <input type="text" name="id" readonly="readyonly" value="<%=cliente.getId()%>"></p>
				<p>Nome: <input type="text" name="nome" placeholder="Nome Completo" value="<%=cliente.getNome()%>"></p>
				<p>CPF: <input type="text" name="cpf" placeholder="Somente Numeros" value="<%=cliente.getCpf()%>"></p>
				<p>RG: <input type="text" name="rg" placeholder="Somente Numeros" value="<%=cliente.getRg()%>"></p>
				<p>Data de Nascimento: <input type="text" name="data_nascimento" placeholder="dd/mm/aaaa" value="<%=data_formatada.format(cliente.getData_nascimento().getTime())%>"></p>
				<p>Nome da Mae: <input type="text" name="nomeMae" value="<%=cliente.getNomeMae()%>"></p>
				<p>Telefone Celular: <input type="text" name="telefone_celular" placeholder="(DDD) XXXXX-XXXX" value="<%=cliente.getTelefone_celular()%>"></p>
				<p>E-Mail: <input type="text" name="email" placeholder="email@email.com" value="<%=cliente.getEmail()%>"></p>
				<p>Estado: <input type="text" name="estado" placeholder="Ex: RN" value="<%=cliente.getEstado()%>"></p>
				<p>Cidade: <input type="text" name="cidade" value="<%=cliente.getCidade()%>"></p>
				<p>Bairro: <input type="text" name="bairro" value="<%=cliente.getBairro()%>"></p>
				<p>Rua: <input type="text" name="rua" value="<%=cliente.getRua()%>"></p>
				<p>CEP: <input type="text" name="cep" placeholder="Somente Numeros" value="<%=cliente.getCep()%>"></p>
				<p>N° da Casa: <input type="text" name="numeroCasa" value="<%=cliente.getNumeroCasa()%>"></p> 
				<!-- <p>Data de Cadastro: <input type="text" nome="data_cadastro" readonly="readonly" value="<%=data_formatada.format(cliente.getData_cadastro().getTime())%>"></p> -->
				<input type="submit" value="Gravar"/>
				<input type="reset" value="Limpar"/>
			</fildset> 
		</form>
		<br/>
		<br/>
		<a href="index.jsp">Pagina Inicial</a>
	</center>
</body>
</html>