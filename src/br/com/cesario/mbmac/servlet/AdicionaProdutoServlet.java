package br.com.cesario.mbmac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cesario.mbmac.database.ProdutoDAO;
import br.com.cesario.mbmac.models.Produto;
/**
 * Essa classe é responsavel por pegar os parametros que vieram dos jsp e os converte para determinado tipo de dado
 * equivalente guarda em um objeto produto e depois envia o objeto para o metodo adiciona() do ProdutoDAO.java
 * @author cesar
 *
 */
@WebServlet("/adicionaproduto")
public class AdicionaProdutoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String nome_produto = request.getParameter("nome_produto");
		String tipo_produto = request.getParameter("tipo_produto");
		String detalhes_produto = request.getParameter("detalhes_produto");
		double altura_produto = Double.parseDouble(request.getParameter("altura_produto"));
		double largura_produto = Double.parseDouble(request.getParameter("largura_produto"));
		double profundidade_produto = Double.parseDouble(request.getParameter("profundidade_produto"));
		double peso_produto = Double.parseDouble(request.getParameter("peso_produto"));
		double preco_compra = Double.parseDouble(request.getParameter("preco_compra"));
		double preco_venda = Double.parseDouble(request.getParameter("preco_venda"));
		
		Produto produto = new Produto();
		produto.setNome_produto(nome_produto);
		produto.setTipo_produto(tipo_produto);
		produto.setDetalhes_produtos(detalhes_produto);
		produto.setAltura_produto(altura_produto);
		produto.setLargura_produto(largura_produto);
		produto.setProfundidade_produto(profundidade_produto);
		produto.setPeso_produto(peso_produto);
		produto.setPreco_compra(preco_compra);
		produto.setPreco_venda(preco_venda);
		produto.setData_cadastro(Calendar.getInstance());
		ProdutoDAO dao = new ProdutoDAO();
		dao.adiciona(produto);

		out.println("<html>");
		out.println("<body>");
		out.println("O Produto " + produto.getNome_produto() + " foi adicionado ao estoque com sucesso");
		out.println("<a href=lista-produtos.jsp> Listar Produtos em Estoque </a>");
		out.println("</body>");
		out.println("</html>");

	}
}
