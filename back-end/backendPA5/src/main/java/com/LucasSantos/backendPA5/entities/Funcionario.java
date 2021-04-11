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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Funcionario;
    private String nome;
    private String cpf;
    private String rg;
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
    private LocalDate admissao;
    private Double salario;
    
    @JsonIgnore
	@OneToMany(mappedBy = "vendedor")
	private List<Pedido> pedidos = new ArrayList<>();
    
    @ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
    public Funcionario () {
    }

	public Funcionario(Long id_Funcionario, String nome, String cpf, String rg, String rua, int numero, String bairro,
			String complemento, String cep, String cidade, String uf, String pais, String telefone, String celular,
			String email, LocalDate admissao, Double salario, Empresa empresa) {
		super();
		this.id_Funcionario = id_Funcionario;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
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
		this.admissao = admissao;
		this.salario = salario;
		this.empresa = empresa;
	}

	public Long getId_Funcionario() {
		return id_Funcionario;
	}

	public void setId_Funcionario(Long id_Funcionario) {
		this.id_Funcionario = id_Funcionario;
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

	public LocalDate getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDate admissao) {
		this.admissao = admissao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Funcionario == null) ? 0 : id_Funcionario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (id_Funcionario == null) {
			if (other.id_Funcionario != null)
				return false;
		} else if (!id_Funcionario.equals(other.id_Funcionario))
			return false;
		return true;
	}
    
}
