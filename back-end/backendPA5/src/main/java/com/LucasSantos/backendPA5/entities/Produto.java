package com.LucasSantos.backendPA5.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Produto;
    private String nome;
    private Double preco_Custo;
    private Double preco_Venda;
    private String categoria;
    private String marca;
    private int lote;
    private String origem;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private Double peso;
    private String validade;
    
    @ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    
    @JsonIgnore
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos = new ArrayList<>();
    
    public Produto() {
    }

	public Produto(Long id_Produto, String nome, Double preco_Custo, Double preco_Venda, String categoria, String marca,
			int lote, String origem, Double altura, Double largura, Double comprimento, Double peso, String validade,
			Fornecedor fornecedor) {
		super();
		this.id_Produto = id_Produto;
		this.nome = nome;
		this.preco_Custo = preco_Custo;
		this.preco_Venda = preco_Venda;
		this.categoria = categoria;
		this.marca = marca;
		this.lote = lote;
		this.origem = origem;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.peso = peso;
		this.validade = validade;
		this.fornecedor = fornecedor;
	}

	public Long getId_Produto() {
		return id_Produto;
	}

	public void setId_Produto(Long id_Produto) {
		this.id_Produto = id_Produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco_Custo() {
		return preco_Custo;
	}

	public void setPreco_Custo(Double preco_Custo) {
		this.preco_Custo = preco_Custo;
	}

	public Double getPreco_Venda() {
		return preco_Venda;
	}

	public void setPreco_Venda(Double preco_Venda) {
		this.preco_Venda = preco_Venda;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Produto == null) ? 0 : id_Produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id_Produto == null) {
			if (other.id_Produto != null)
				return false;
		} else if (!id_Produto.equals(other.id_Produto))
			return false;
		return true;
	}
    
}
