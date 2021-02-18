package com.pa4.pa4.service;

import com.pa4.pa4.dto.ProprietarioDTO;
import com.pa4.pa4.model.Proprietario;

import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

    public Proprietario fromDTO(ProprietarioDTO dto) {
        Proprietario p = new Proprietario();
        p.setNome(dto.getNome());
        p.setCPF(dto.getCPF());
        p.setRG(dto.getRG());
        p.setCNPJ(dto.getCNPJ());
        p.setIE(dto.getIE());
        p.setRazao_Social(dto.getRazao_Social());
        p.setRamo_Atividade(dto.getRamo_Atividade());
        p.setNome_Fantasia(dto.getNome_Fantasia());
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
        p.setPorte(dto.getPorte());
        p.setCNAE(dto.getCNAE());
        p.setFilial(dto.getFilial());

        return p;
    }
}
