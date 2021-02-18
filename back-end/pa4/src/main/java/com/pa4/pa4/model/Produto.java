package com.pa4.pa4.model;

public class Produto {
    
    private int ID_Produto;
    private String Nome;
    private Double Preco_Custo;
    private Double Preco_Venda;
    private String Categoria;
    private String Marca;
    private int Lote;
    private String Origem;
    private Double Altura;
    private Double Largura;
    private Double Comprimento;
    private Double Peso;
    private String Validade;
    private int ID_FornecedorP;;

    public Produto(){
    }

    public int getID_Produto() {
        return ID_Produto;
    }

    public void setID_Produto(int iD_Produto) {
        ID_Produto = iD_Produto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getPreco_Custo() {
        return Preco_Custo;
    }

    public void setPreco_Custo(Double preco_Custo) {
        Preco_Custo = preco_Custo;
    }

    public Double getPreco_Venda() {
        return Preco_Venda;
    }

    public void setPreco_Venda(Double preco_Venda) {
        Preco_Venda = preco_Venda;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getLote() {
        return Lote;
    }

    public void setLote(int lote) {
        Lote = lote;
    }

    public String getOrigem() {
        return Origem;
    }

    public void setOrigem(String origem) {
        Origem = origem;
    }

    public Double getAltura() {
        return Altura;
    }

    public void setAltura(Double altura) {
        Altura = altura;
    }

    public Double getLargura() {
        return Largura;
    }

    public void setLargura(Double largura) {
        Largura = largura;
    }

    public Double getComprimento() {
        return Comprimento;
    }

    public void setComprimento(Double comprimento) {
        Comprimento = comprimento;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double peso) {
        Peso = peso;
    }

    public String getValidade() {
        return Validade;
    }

    public void setValidade(String validade) {
        Validade = validade;
    }

    public int getID_FornecedorP() {
        return ID_FornecedorP;
    }

    public void setID_FornecedorP(int iD_FornecedorP) {
        ID_FornecedorP = iD_FornecedorP;
    }

    public Produto(int iD_Produto, String nome, Double preco_Custo, Double preco_Venda, String categoria, String marca,
            int lote, String origem, Double altura, Double largura, Double comprimento, Double peso, String validade,
            int iD_FornecedorP) {
        ID_Produto = iD_Produto;
        Nome = nome;
        Preco_Custo = preco_Custo;
        Preco_Venda = preco_Venda;
        Categoria = categoria;
        Marca = marca;
        Lote = lote;
        Origem = origem;
        Altura = altura;
        Largura = largura;
        Comprimento = comprimento;
        Peso = peso;
        Validade = validade;
        ID_FornecedorP = iD_FornecedorP;
    }

    

    

    
    
}
