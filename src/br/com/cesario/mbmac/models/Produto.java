package br.com.cesario.mbmac.models;

import java.util.Calendar;
/**
 * Classe modelo de um produto para adicionar ao banco.
 * @author cesar
 *
 */
public class Produto {
	private long id;
	private String nome_produto;
	private String tipo_produto;
	private String detalhes_produtos;
	private double altura_produto;
	private double largura_produto;
	private double profundidade_produto;
	private double peso_produto;
	private double preco_compra;
	private double preco_venda;
	private Calendar data_cadastro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public String getDetalhes_produtos() {
		return detalhes_produtos;
	}

	public void setDetalhes_produtos(String detalhes_produtos) {
		this.detalhes_produtos = detalhes_produtos;
	}

	public double getAltura_produto() {
		return altura_produto;
	}

	public void setAltura_produto(double altura_produto) {
		this.altura_produto = altura_produto;
	}

	public double getLargura_produto() {
		return largura_produto;
	}

	public void setLargura_produto(double largura_produto) {
		this.largura_produto = largura_produto;
	}

	public double getProfundidade_produto() {
		return profundidade_produto;
	}

	public void setProfundidade_produto(double profundidade_produto) {
		this.profundidade_produto = profundidade_produto;
	}

	public double getPeso_produto() {
		return peso_produto;
	}

	public void setPeso_produto(double peso_produto) {
		this.peso_produto = peso_produto;
	}

	public double getPreco_compra() {
		return preco_compra;
	}

	public void setPreco_compra(double preco_compra) {
		this.preco_compra = preco_compra;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Calendar getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

}
