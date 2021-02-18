package com.pa4.pa4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pa4.pa4.dto.VendaDTO;
import com.pa4.pa4.model.Venda;
import com.pa4.pa4.repository.VendaRepository;
import com.pa4.pa4.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/vendas")
public class VendaControllers {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private VendaService servico;

    @GetMapping
    public List<Venda> getVenda(){
        return repository.getAllVendas();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable int id){
        Venda venda = repository.getVendaById(id);
        
        if(venda != null)    
            return ResponseEntity.ok(venda);
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody VendaDTO novaVenda,
                                       HttpServletRequest request,
                                       UriComponentsBuilder builder) {
        Venda venda = repository.salvar(servico.fromDTO(novaVenda));

        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+venda.getId_Venda()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();

    }
   
}
