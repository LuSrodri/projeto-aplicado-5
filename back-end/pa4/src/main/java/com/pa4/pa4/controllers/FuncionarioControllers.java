package com.pa4.pa4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pa4.pa4.dto.FuncionarioDTO;
import com.pa4.pa4.model.Funcionario;
import com.pa4.pa4.repository.FuncionarioRepository;
import com.pa4.pa4.service.FuncionarioService;

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
@RequestMapping("/funcionarios")
public class FuncionarioControllers {
    
    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioService servico;

    @GetMapping
    public List<Funcionario> getFuncionario(){
        return repository.getAllFuncionarios();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable int id){
        Funcionario funcionario = repository.getFuncionarioById(id);
        
        if(funcionario != null)    
            return ResponseEntity.ok(funcionario);
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody FuncionarioDTO novoFuncionario,
                                       HttpServletRequest request,
                                       UriComponentsBuilder builder) {
        Funcionario funcionario = repository.salvar(servico.fromDTO(novoFuncionario));

        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+funcionario.getID_Funcionario()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();

    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        Funcionario funcionario = repository.getFuncionarioById(id);
        
        if(funcionario != null){   
            repository.remove(funcionario);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable int id, @RequestBody FuncionarioDTO funcionarioDTO){
    
        if(repository.getFuncionarioById(id) != null){
            
            Funcionario funcionario = servico.fromDTO(funcionarioDTO);
            funcionario.setID_Funcionario(id);
            funcionario = repository.update(funcionario);
            return ResponseEntity.ok(funcionario);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

