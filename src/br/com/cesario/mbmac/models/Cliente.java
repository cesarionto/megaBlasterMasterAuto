package br.com.cesario.mbmac.models;

import java.util.Calendar;
/**
 * Classe modelo de um cliente para adicionar ao banco.
 * @author cesar
 *
 */
public class Cliente {
	private long id;
	private String nome;
	private String cpf;
	private String rg;
	private Calendar data_nascimento;
	private String nomeMae;
	private String telefone_celular;
	private String email;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String cep;
	private String numeroCasa;
	private Calendar data_cadastro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Calendar getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Calendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getTelefone_celular() {
		return telefone_celular;
	}

	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public Calendar getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

}
