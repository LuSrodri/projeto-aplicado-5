package com.pa4.pa4.service;

import com.pa4.pa4.dto.VendaDTO;
import com.pa4.pa4.model.Venda;

import org.springframework.stereotype.Service;

@Service
public class VendaService {
    public Venda fromDTO(VendaDTO dto) {
        Venda p = new Venda();

        p.setData(dto.getData());
        p.setId_Cliente(dto.getId_Cliente());
        p.setId_Produto(dto.getId_Produto());

        return p;
    }
}
