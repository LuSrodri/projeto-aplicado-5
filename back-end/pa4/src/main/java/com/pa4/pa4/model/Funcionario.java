package com.pa4.pa4.model;

public class Funcionario {
    
    private int ID_Funcionario;
    private String Nome;
    private String CPF;
    private String RG;
    private String Rua;
    private int Numero;
    private String Bairro;
    private String Complemento;
    private String CEP;
    private String Cidade;
    private String UF;
    private String Pais;
    private String Telefone;
    private String Celular;
    private String Email;
    private String Admissao;
    private Double Salario;

    public Funcionario(){
    }

    public int getID_Funcionario() {
        return ID_Funcionario;
    }

    public void setID_Funcionario(int iD_Funcionario) {
        ID_Funcionario = iD_Funcionario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        RG = rG;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String uF) {
        UF = uF;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdmissao() {
        return Admissao;
    }

    public void setAdmissao(String admissao) {
        Admissao = admissao;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }

    public Funcionario(int iD_Funcionario, String nome, String cPF, String rG, String rua, int numero, String bairro,
            String complemento, String cEP, String cidade, String uF, String pais, String telefone, String celular,
            String email, String admissao, Double salario) {
        ID_Funcionario = iD_Funcionario;
        Nome = nome;
        CPF = cPF;
        RG = rG;
        Rua = rua;
        Numero = numero;
        Bairro = bairro;
        Complemento = complemento;
        CEP = cEP;
        Cidade = cidade;
        UF = uF;
        Pais = pais;
        Telefone = telefone;
        Celular = celular;
        Email = email;
        Admissao = admissao;
        Salario = salario;
    }

	
}