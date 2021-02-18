package com.pa4.pa4.service;

import com.pa4.pa4.dto.ProdutoDTO;
import com.pa4.pa4.model.Produto;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    public Produto fromDTO(ProdutoDTO dto){
        Produto p = new Produto();
        
        p.setNome(dto.getNome());
        p.setPreco_Custo(dto.getPreco_Custo());
        p.setPreco_Venda(dto.getPreco_Venda());
        p.setCategoria(dto.getCategoria());
        p.setMarca(dto.getMarca());
        p.setLote(dto.getLote());
        p.setOrigem(dto.getOrigem());
        p.setAltura(dto.getAltura());
        p.setLargura(dto.getLargura());
        p.setComprimento(dto.getComprimento());
        p.setPeso(dto.getPeso());
        p.setValidade(dto.getValidade());
        p.setID_FornecedorP(dto.getID_FornecedorP());

        return p;
    }
}
