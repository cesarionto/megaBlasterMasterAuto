package br.com.cesario.mbmac.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.cesario.mbmac.models.Cliente;

/**
 * Classe onde tem metodos responsaveis por pegar um objeto de cliente e fazer
 * opera��es no banco de dados atraves de SQL.
 * 
 * @author cesar
 *
 */
public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/**
	 * Este metoduto adiciona um cliente ao banco de dados preenchendo todos os
	 * campos da tabela clientes.
	 * 
	 * @param cliente
	 */
	public void adiciona(Cliente cliente) {
		String sql = "insert into clientes " + "(nome,cpf,rg,data_nascimento,nomemae, "
				+ "telefone_celular, email , estado, cidade," + "bairro,rua, cep,numerocasa,data_cadastro)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setDate(4, new Date(cliente.getData_nascimento().getTimeInMillis()));
			stmt.setString(5, cliente.getNomeMae());
			stmt.setString(6, cliente.getTelefone_celular());
			stmt.setString(7, cliente.getEmail());
			stmt.setString(8, cliente.getEstado());
			stmt.setString(9, cliente.getCidade());
			stmt.setString(10, cliente.getBairro());
			stmt.setString(11, cliente.getRua());
			stmt.setString(12, cliente.getCep());
			stmt.setString(13, cliente.getNumeroCasa());
			stmt.setDate(14, new Date(cliente.getData_cadastro().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * este metudo retorna todos os clientes do banco de dados, cria um objeto do
	 * tipo de cliente e set nos campos do modelo cliente. o metudo retorna uma
	 * lista.
	 * 
	 * @return
	 */
	public List<Cliente> getLista() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * from clientes ORDER BY nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));

				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("data_nascimento"));
				cliente.setData_nascimento(dataNascimento);

				cliente.setNomeMae(rs.getString("nomemae"));
				cliente.setTelefone_celular(rs.getString("telefone_celular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setRua(rs.getString("rua"));
				cliente.setCep(rs.getString("cep"));
				cliente.setNumeroCasa(rs.getString("numerocasa"));

				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("data_cadastro"));
				cliente.setData_cadastro(dataCadastro);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * remove um danado de um cliente com base no ID do caba.
	 * 
	 * @param cliente
	 */
	public void remove(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clientes where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * este metudo pega uma string chamada id que vem do jsp quando pede para
	 * remover ou alterar um cliente ele nos retorna um cliente do banco com base
	 * nesse id.
	 * 
	 * @param id
	 * @return
	 */
	public Cliente getClienteById(String id) {
		Cliente cliente = new Cliente();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM clientes WHERE id=?");
			stmt.setLong(1, Long.parseLong(id));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));

				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("data_nascimento"));

				cliente.setData_nascimento(dataNascimento);
				cliente.setNomeMae(rs.getString("nome_mae"));
				cliente.setTelefone_celular(rs.getString("telefone_celular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setRua(rs.getString("rua"));
				cliente.setCep(rs.getString("cep"));
				cliente.setNumeroCasa(rs.getString("numerocasa"));

				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("data_cadastro"));
				cliente.setData_cadastro(dataCadastro);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cliente;
	}

	/**
	 * Altera um cliente atualizando as informa�oes do banco.
	 * 
	 * @param cliente
	 */
	public void altera(Cliente cliente) {
		String sql = "update clientes set nome=? ,cpf=? ,rg=? ,data_nascimento=? ,"
				+ "nomemae=?, telefone_celular=?, email=? , estado=?, cidade=?, "
				+ "bairro=?,rua=?, cep=?,numerocasa=?,data_cadastro=? where id=? ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setDate(4, new Date(cliente.getData_nascimento().getTimeInMillis()));
			stmt.setString(5, cliente.getNomeMae());
			stmt.setString(6, cliente.getTelefone_celular());
			stmt.setString(7, cliente.getEmail());
			stmt.setString(8, cliente.getEstado());
			stmt.setString(9, cliente.getCidade());
			stmt.setString(10, cliente.getBairro());
			stmt.setString(11, cliente.getRua());
			stmt.setString(12, cliente.getCep());
			stmt.setString(13, cliente.getNumeroCasa());
			stmt.setDate(14, new Date(cliente.getData_cadastro().getTimeInMillis()));
			stmt.setLong(15, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
/**
 * Esse metudo retorna uma lista de clientes cadastrado no banco de acordo com o ano pesquisado pelo usuario 
 * @param data_cadastro
 * @return
 */
	public List<Cliente> getListaNovosClientes(String data_cadastro) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM clientes WHERE YEAR(clientes.data_cadastro) = ? ");
			stmt.setLong(1, Long.parseLong(data_cadastro));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));

				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("data_nascimento"));
				cliente.setData_nascimento(dataNascimento);

				cliente.setNomeMae(rs.getString("nomemae"));
				cliente.setTelefone_celular(rs.getString("telefone_celular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setRua(rs.getString("rua"));
				cliente.setCep(rs.getString("cep"));
				cliente.setNumeroCasa(rs.getString("numerocasa"));

				Calendar dataCadastro = Calendar.getInstance();
				dataCadastro.setTime(rs.getDate("data_cadastro"));
				cliente.setData_cadastro(dataCadastro);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
