package com.pa4.pa4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pa4.pa4.dto.FornecedorDTO;
import com.pa4.pa4.model.Fornecedor;
import com.pa4.pa4.repository.FornecedorRepository;
import com.pa4.pa4.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorControllers {
    
    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private FornecedorService servico;

    @GetMapping
    public List<Fornecedor> getFornecedor(){
        return repository.getAllFornecedores();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable int id){
        Fornecedor fornecedor = repository.getFornecedorById(id);
        
        if(fornecedor != null)    
            return ResponseEntity.ok(fornecedor);
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody FornecedorDTO novoFornecedor,
                                       HttpServletRequest request,
                                       UriComponentsBuilder builder) {
        Fornecedor fornecedor = repository.salvar(servico.fromDTO(novoFornecedor));

        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+fornecedor.getID_Fornecedor()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();

    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        Fornecedor fornecedor = repository.getFornecedorById(id);
        
        if(fornecedor != null){   
            repository.remove(fornecedor);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable int id, @RequestBody FornecedorDTO fornecedorDTO){
    
        if(repository.getFornecedorById(id) != null){
            
            Fornecedor fornecedor = servico.fromDTO(fornecedorDTO);
            fornecedor.setID_Fornecedor(id);
            fornecedor = repository.update(fornecedor);
            return ResponseEntity.ok(fornecedor);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

