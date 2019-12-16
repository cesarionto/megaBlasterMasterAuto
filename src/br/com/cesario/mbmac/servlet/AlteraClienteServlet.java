package br.com.cesario.mbmac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cesario.mbmac.database.ClienteDAO;
import br.com.cesario.mbmac.models.Cliente;
/**
 * Essa classe é responsavel por pegar os parametros que vieram dos jsp e os converte para determinado tipo de dado
 * equivalente guarda em um objeto cliente e depois envia o objeto para o metodo altera() do ClienteDAO.java
 * @author cesar
 *
 */
@WebServlet("/alteracliente")
public class AlteraClienteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String dataDeNascimentoEmTexto = request.getParameter("data_nascimento");
		String nomeMae = request.getParameter("nomeMae");
		String telefone_celular = request.getParameter("telefone_celular");
		String email = request.getParameter("email");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String numeroCasa = request.getParameter("numeroCasa");

		Calendar dataNascimento = null;
		Calendar data_cadastro = null;
		try {
			Date data_nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataDeNascimentoEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data_nascimento);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;
		}


		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setData_nascimento(dataNascimento);
		cliente.setNomeMae(nomeMae);
		cliente.setTelefone_celular(telefone_celular);
		cliente.setEmail(email);
		cliente.setEstado(estado);
		cliente.setCidade(cidade);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setRua(rua);
		cliente.setCep(cep);
		cliente.setNumeroCasa(numeroCasa);
		cliente.setData_cadastro(Calendar.getInstance());
		ClienteDAO dao = new ClienteDAO();
		dao.altera(cliente);

		out.println("<html>");
		out.println("<body>");
		out.println("Cliente " + cliente.getNome() + " alterado com sucesso");
		out.println("<a href=lista-clientes.jsp> Listar Clientes </a>");
		out.println("</body>");
		out.println("</html>");

	}
}
