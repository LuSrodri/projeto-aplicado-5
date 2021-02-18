package com.pa4.pa4.model;


public class Proprietario {
    
    private int ID_Proprietario;
    private String nome;
    private String CPF;
    private String RG;
    private String CNPJ;
    private String IE;
    private String Razao_Social;
    private String Ramo_Atividade;
    private String Nome_Fantasia;
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
    private String Porte;
    private String CNAE;
    private int Filial;

    public Proprietario() {
    }

    public int getID_Proprietario() {
        return ID_Proprietario;
    }

    public void setID_Proprietario(final int iD_Proprietario) {
        ID_Proprietario = iD_Proprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(final String cPF) {
        CPF = cPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(final String rG) {
        RG = rG;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(final String cNPJ) {
        CNPJ = cNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(final String iE) {
        IE = iE;
    }

    public String getRazao_Social() {
        return Razao_Social;
    }

    public void setRazao_Social(final String razao_Social) {
        Razao_Social = razao_Social;
    }

    public String getRamo_Atividade() {
        return Ramo_Atividade;
    }

    public void setRamo_Atividade(final String ramo_Atividade) {
        Ramo_Atividade = ramo_Atividade;
    }

    public String getNome_Fantasia() {
        return Nome_Fantasia;
    }

    public void setNome_Fantasia(final String nome_Fantasia) {
        Nome_Fantasia = nome_Fantasia;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(final String rua) {
        Rua = rua;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(final int numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(final String bairro) {
        Bairro = bairro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(final String complemento) {
        Complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(final String cEP) {
        CEP = cEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(final String cidade) {
        Cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(final String uF) {
        UF = uF;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(final String pais) {
        Pais = pais;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(final String telefone) {
        Telefone = telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(final String celular) {
        Celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(final String email) {
        Email = email;
    }

    public String getPorte() {
        return Porte;
    }

    public void setPorte(final String porte) {
        Porte = porte;
    }

    public String getCNAE() {
        return CNAE;
    }

    public void setCNAE(final String cNAE) {
        CNAE = cNAE;
    }

    public int getFilial() {
        return Filial;
    }

    public void setFilial(final int filial) {
        Filial = filial;
    }

    public Proprietario(final int iD_Proprietario, final String nome, final String cPF, final String rG, final String cNPJ, final String iE,
            final String razao_Social, final String ramo_Atividade, final String nome_Fantasia, final String rua, final int numero, final String bairro,
            final String complemento, final String cEP, final String cidade, final String uF, final String pais, final String telefone, final String celular,
            final String email, final String porte, final String cNAE, final int filial) {
        ID_Proprietario = iD_Proprietario;
        this.nome = nome;
        CPF = cPF;
        RG = rG;
        CNPJ = cNPJ;
        IE = iE;
        Razao_Social = razao_Social;
        Ramo_Atividade = ramo_Atividade;
        Nome_Fantasia = nome_Fantasia;
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
        Porte = porte;
        CNAE = cNAE;
        Filial = filial;
    }

}