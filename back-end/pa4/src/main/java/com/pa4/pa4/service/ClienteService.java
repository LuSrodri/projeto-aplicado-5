package com.pa4.pa4.service;

import com.pa4.pa4.dto.ClienteDTO;
import com.pa4.pa4.model.Cliente;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    public Cliente fromDTO(ClienteDTO dto){
        Cliente p = new Cliente();

        p.setNome(dto.getNome());
        p.setCPF(dto.getCPF());
        p.setRG(dto.getRG());
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
