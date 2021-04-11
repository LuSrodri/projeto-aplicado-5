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
@Table(name = "tb_empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Empresa;
    private String nome;
    private String cnpj;
    private String ie;
    private String razao_Social;
    private String ramo_Atividade;
    private String nome_Fantasia;
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
    private String porte;
    private String cnae;
    private String filial;
    
    @JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Funcionario> funcionarios = new ArrayList<>();
    
    @JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Cliente> clientes = new ArrayList<>();
    
    public Empresa() {
    }

	public Empresa(Long id_Empresa, String nome, String cnpj, String ie, String razao_Social, String ramo_Atividade,
			String nome_Fantasia, String rua, int numero, String bairro, String complemento, String cep, String cidade,
			String uf, String pais, String telefone, String celular, String email, String porte, String cnae,
			String filial) {
		super();
		this.id_Empresa = id_Empresa;
		this.nome = nome;
		this.cnpj = cnpj;
		this.ie = ie;
		this.razao_Social = razao_Social;
		this.ramo_Atividade = ramo_Atividade;
		this.nome_Fantasia = nome_Fantasia;
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
		this.porte = porte;
		this.cnae = cnae;
		this.filial = filial;
	}

	public Long getId_Empresa() {
		return id_Empresa;
	}

	public void setId_Empresa(Long id_Empresa) {
		this.id_Empresa = id_Empresa;
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

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
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

	public String getNome_Fantasia() {
		return nome_Fantasia;
	}

	public void setNome_Fantasia(String nome_Fantasia) {
		this.nome_Fantasia = nome_Fantasia;
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

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Empresa == null) ? 0 : id_Empresa.hashCode());
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
		Empresa other = (Empresa) obj;
		if (id_Empresa == null) {
			if (other.id_Empresa != null)
				return false;
		} else if (!id_Empresa.equals(other.id_Empresa))
			return false;
		return true;
	}
    
}
