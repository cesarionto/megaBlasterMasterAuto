package br.com.cesario.mbmac.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.cesario.mbmac.models.Produto;
/**
 * Classe onde tem metodos responsaveis por pegar um objeto de produto e fazer opera��es
 * no banco de dados atraves de SQL.
 * @author cesar
 *
 */
public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	/**
	 * Este metoduto adiciona um cliente ao banco de dados preenchendo todos os campos da tabela clientes.
	 * @param produto
	 */
	public void adiciona(Produto produto) {
		String sql = "insert into produtos " + "(nome_produto, tipo_produto, detalhes_produto, altura_produto, "
				+ "largura_produto, profundidade_produto, peso_produto, preco_compra, preco_venda, data_cadastro)" 
				+ " values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome_produto());
			stmt.setString(2, produto.getTipo_produto());
			stmt.setString(3, produto.getDetalhes_produtos());
			stmt.setDouble(4, produto.getAltura_produto());
			stmt.setDouble(5, produto.getLargura_produto());
			stmt.setDouble(6, produto.getProfundidade_produto());
			stmt.setDouble(7, produto.getPeso_produto());
			stmt.setDouble(8, produto.getPreco_compra());
			stmt.setDouble(9, produto.getPreco_venda());
			stmt.setDate(10 , new Date(produto.getData_cadastro().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * este metudo retorna todos os clientes do banco de dados, cria um objeto do tipo de produto e set nos campos 
	 * do modelo produto. o metudo retorna uma lista de produtos. 
	 * @return
	 */
	public List<Produto> getLista() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * from produtos ORDER BY id");
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Produto produto = new Produto();
				produto.setId(resultado.getLong("id"));
				produto.setNome_produto(resultado.getString("nome_produto"));
				produto.setTipo_produto(resultado.getString("tipo_produto"));
				produto.setDetalhes_produtos(resultado.getString("detalhes_produto"));
				produto.setAltura_produto(resultado.getDouble("altura_produto"));
				produto.setLargura_produto(resultado.getDouble("largura_produto"));
				produto.setProfundidade_produto(resultado.getDouble("profundidade_produto"));
				produto.setPeso_produto(resultado.getDouble("peso_produto"));
				produto.setPreco_compra(resultado.getDouble("preco_compra"));
				produto.setPreco_venda(resultado.getDouble("preco_venda"));
				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(resultado.getDate("data_cadastro"));
				produto.setData_cadastro(dataCadastro);
			
				produtos.add(produto);
			}
			resultado.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Esse metudo retorna para o usuario uma lista de produtos do banco de dados ordenado pela data de cadastro de forma ascendente.
	 * @return List<Produto>
	 */
	public List<Produto> getEncalhados() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos WHERE EXISTS "
								+ "(SELECT * from produtos order by produtos.data_cadastro asc) "
								+ "ORDER by produtos.preco_compra DESC LIMIT 3");
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Produto produto = new Produto();
				produto.setId(resultado.getLong("id"));
				produto.setNome_produto(resultado.getString("nome_produto"));
				produto.setTipo_produto(resultado.getString("tipo_produto"));
				produto.setDetalhes_produtos(resultado.getString("detalhes_produto"));
				produto.setAltura_produto(resultado.getDouble("altura_produto"));
				produto.setLargura_produto(resultado.getDouble("largura_produto"));
				produto.setProfundidade_produto(resultado.getDouble("profundidade_produto"));
				produto.setPeso_produto(resultado.getDouble("peso_produto"));
				produto.setPreco_compra(resultado.getDouble("preco_compra"));
				produto.setPreco_venda(resultado.getDouble("preco_venda"));
				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(resultado.getDate("data_cadastro"));
				produto.setData_cadastro(dataCadastro);
			
				produtos.add(produto);
			}
			resultado.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * remove um produto com base no ID do banco.
	 * @param cliente
	 */
	public void remove(Produto produto) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produtos where id=?");
			stmt.setLong(1, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * este metudo pega uma string chamada id que vem do jsp quando pede para remover ou alterar um produto
	 *ele nos retorna um produto do banco com base nesse id.
	 * @param id
	 * @return
	 */
	public Produto getProdutoById(String id) {
		Produto produto = new Produto();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM produtos WHERE id=?");
			stmt.setLong(1, Long.parseLong(id));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				produto.setId(rs.getLong("id"));
				produto.setNome_produto(rs.getString("nome_produto"));
				produto.setTipo_produto(rs.getString("tipo_produto"));
				produto.setDetalhes_produtos(rs.getString("detalhes_produto"));
				produto.setAltura_produto(rs.getDouble("altura_produto"));
				produto.setLargura_produto(rs.getDouble("largura_produto"));
				produto.setProfundidade_produto(rs.getDouble("profundidade_produto"));
				produto.setPeso_produto(rs.getDouble("peso_produto"));
				produto.setPreco_compra(rs.getDouble("preco_compra"));
				produto.setPreco_venda(rs.getDouble("preco_venda"));
				
				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("data_cadastro"));
				produto.setData_cadastro(dataCadastro);
				

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produto;
	}
	/**
	 * Altera um produto atualizando as informa�oes do banco.
	 * @param cliente
	 */
	public void altera(Produto produto) {
		String sql = 
		"update produtos set nome_produto=? ,tipo_produto=? ,detalhes_produto=? ,"
		+ "altura_produto=?, largura_produto=?, profundidade_produto=? , peso_produto=?, preco_compra=?, "
		+ "preco_venda=?, data_cadastro=? where id=? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome_produto());
			stmt.setString(2, produto.getTipo_produto());
			stmt.setString(3, produto.getDetalhes_produtos());
			stmt.setDouble(4, produto.getAltura_produto());
			stmt.setDouble(5, produto.getLargura_produto());
			stmt.setDouble(6, produto.getProfundidade_produto());
			stmt.setDouble(7, produto.getPeso_produto());
			stmt.setDouble(8, produto.getPreco_compra());
			stmt.setDouble(9, produto.getPreco_venda());
			
			stmt.setDate(10 , new Date(produto.getData_cadastro().getTimeInMillis()));
			stmt.setLong(11, produto.getId());
			stmt.execute();
			stmt.close();
			System.out.println("estou em altera produtoDAO: "+stmt);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
