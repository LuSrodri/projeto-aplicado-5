package com.pa4.pa4.service;

import com.pa4.pa4.dto.FornecedorDTO;
import com.pa4.pa4.model.Fornecedor;

import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    
    public Fornecedor fromDTO(FornecedorDTO dto){
        Fornecedor p = new Fornecedor();

        p.setNome(dto.getNome());
        p.setCNPJ(dto.getCNPJ());
        p.setRazao_Social(dto.getRazao_Social());
        p.setRamo_Atividade(dto.getRamo_Atividade());
        p.setRua(dto.getRua());
        p.setNumero(dto.getNumero());
        p.setBairro(dto.getBairro());
        p.setComplemento(dto.getComplemento());
        p.setCEP(dto.getCEP());
        p.setCidade(dto.getCidade());
        p.setUF(dto.getUF());
        p.setPais(dto.getPais());
        p.setTelefone(dto.getTelefone());
        p.setCelular(dto.getCelular());
        p.setEmail(dto.getEmail());
        
        return p;
    }
}
