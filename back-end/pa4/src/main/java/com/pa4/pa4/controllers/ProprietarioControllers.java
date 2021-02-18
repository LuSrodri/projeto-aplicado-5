package com.pa4.pa4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pa4.pa4.dto.ProprietarioDTO;
import com.pa4.pa4.model.Proprietario;
import com.pa4.pa4.repository.ProprietarioRepository;
import com.pa4.pa4.service.ProprietarioService;

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
@RequestMapping("/proprietarios")
public class ProprietarioControllers {
    
    @Autowired
    private ProprietarioRepository repository;

    @Autowired
    private ProprietarioService servico;

    @GetMapping
    public List<Proprietario> getProprietario(){
        return repository.getAllProprietarios();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> getProprietarioById(@PathVariable int id){
        Proprietario proprietario = repository.getProprietarioById(id);
        
        if(proprietario != null)    
            return ResponseEntity.ok(proprietario);
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ProprietarioDTO novoProprietario,
                                       HttpServletRequest request,
                                       UriComponentsBuilder builder) {
        Proprietario proprietario = repository.salvar(servico.fromDTO(novoProprietario));

        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+proprietario.getID_Proprietario()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();

    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        Proprietario proprietario = repository.getProprietarioById(id);
        
        if(proprietario != null){   
            repository.remove(proprietario);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable int id, @RequestBody ProprietarioDTO proprietarioDTO){
    
        if(repository.getProprietarioById(id) != null){
            
            Proprietario proprietario = servico.fromDTO(proprietarioDTO);
            proprietario.setID_Proprietario(id);
            proprietario = repository.update(proprietario);
            return ResponseEntity.ok(proprietario);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
