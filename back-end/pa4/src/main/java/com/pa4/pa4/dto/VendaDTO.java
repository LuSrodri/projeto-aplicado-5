package com.pa4.pa4.dto;

public class VendaDTO {
    private String data;
    private int Id_Cliente;
    private int Id_Produto;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public int getId_Produto() {
        return Id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        Id_Produto = id_Produto;
    }
    
}