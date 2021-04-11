package com.LucasSantos.backendPA5.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Fornecedor;
    private String nome;
    private String cnpj;
    private String razao_Social;
    private String ramo_Atividade;
    private String rua;
    private int numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
    private String pais;
    private String telefone;
    private String celular;
    private String email;
    
    @JsonIgnore
	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtos = new ArrayList<>();
    
    public Fornecedor() {
    }

	public Fornecedor(Long id_Fornecedor, String nome, String cnpj, String razao_Social, String ramo_Atividade,
			String rua, int numero, String bairro, String complemento, String cep, String cidade, String uf,
			String pais, String telefone, String celular, String email) {
		super();
		this.id_Fornecedor = id_Fornecedor;
		this.nome = nome;
		this.cnpj = cnpj;
		this.razao_Social = razao_Social;
		this.ramo_Atividade = ramo_Atividade;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public Long getId_Fornecedor() {
		return id_Fornecedor;
	}

	public void setId_Fornecedor(Long id_Fornecedor) {
		this.id_Fornecedor = id_Fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazao_Social() {
		return razao_Social;
	}

	public void setRazao_Social(String razao_Social) {
		this.razao_Social = razao_Social;
	}

	public String getRamo_Atividade() {
		return ramo_Atividade;
	}

	public void setRamo_Atividade(String ramo_Atividade) {
		this.ramo_Atividade = ramo_Atividade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		result = prime * result + ((id_Fornecedor == null) ? 0 : id_Fornecedor.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (id_Fornecedor == null) {
			if (other.id_Fornecedor != null)
				return false;
		} else if (!id_Fornecedor.equals(other.id_Fornecedor))
			return false;
		return true;
	}
    
}
