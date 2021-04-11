package com.LucasSantos.backendPA5.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Pedido;
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Funcionario vendedor;
	
	@ManyToMany
	@JoinTable(name = "tb_pedido_produto",
	joinColumns = @JoinColumn(name = "pedido_id"),
	inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Long id_Pedido, LocalDate data, Cliente cliente, Funcionario vendedor) {
		super();
		this.id_Pedido = id_Pedido;
		this.data = data;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}

	public Long getId_Pedido() {
		return id_Pedido;
	}

	public void setId_Pedido(Long id_Pedido) {
		this.id_Pedido = id_Pedido;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Pedido == null) ? 0 : id_Pedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id_Pedido == null) {
			if (other.id_Pedido != null)
				return false;
		} else if (!id_Pedido.equals(other.id_Pedido))
			return false;
		return true;
	}
	
}
