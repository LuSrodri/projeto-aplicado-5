package com.pa4.pa4.model;

public class Fornecedor {
    
    private int ID_Fornecedor;
    private String Nome;
    private String CNPJ;
    private String Razao_Social;
    private String Ramo_Atividade;
    private String Rua;
    private int Numero;
    private String Bairro;
    private String Complemento;
    private String CEP;
    private String cidade;
    private String UF;
    private String Pais;
    private String Telefone;
    private String Celular;
    private String Email;

    public Fornecedor(){
    }

    public int getID_Fornecedor() {
        return ID_Fornecedor;
    }

    public void setID_Fornecedor(int iD_Fornecedor) {
        ID_Fornecedor = iD_Fornecedor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }

    public String getRazao_Social() {
        return Razao_Social;
    }

    public void setRazao_Social(String razao_Social) {
        Razao_Social = razao_Social;
    }

    public String getRamo_Atividade() {
        return Ramo_Atividade;
    }

    public void setRamo_Atividade(String ramo_Atividade) {
        Ramo_Atividade = ramo_Atividade;
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
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public Fornecedor(int iD_Fornecedor, String nome, String cNPJ, String razao_Social, String ramo_Atividade,
            String rua, int numero, String bairro, String complemento, String cEP, String cidade, String uF,
            String pais, String telefone, String celular, String email) {
        ID_Fornecedor = iD_Fornecedor;
        Nome = nome;
        CNPJ = cNPJ;
        Razao_Social = razao_Social;
        Ramo_Atividade = ramo_Atividade;
        Rua = rua;
        Numero = numero;
        Bairro = bairro;
        Complemento = complemento;
        CEP = cEP;
        this.cidade = cidade;
        UF = uF;
        Pais = pais;
        Telefone = telefone;
        Celular = celular;
        Email = email;
    }

    
}
