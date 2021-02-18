package com.pa4.pa4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pa4.pa4.dto.ClienteDTO;
import com.pa4.pa4.model.Cliente;
import com.pa4.pa4.repository.ClienteRepository;
import com.pa4.pa4.service.ClienteService;

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
@RequestMapping("/clientes")
public class ClienteControllers {
    
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService servico;

    @GetMapping
    public List<Cliente> getCliente(){
        return repository.getAllClientes();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id){
        Cliente cliente = repository.getClienteById(id);
        
        if(cliente != null)    
            return ResponseEntity.ok(cliente);
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ClienteDTO novoCliente,
                                       HttpServletRequest request,
                                       UriComponentsBuilder builder) {
        Cliente cliente = repository.salvar(servico.fromDTO(novoCliente));

        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+cliente.getID_Cliente()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();

    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        Cliente cliente = repository.getClienteById(id);
        
        if(cliente != null){   
            repository.remove(cliente);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int id, @RequestBody ClienteDTO clienteDTO){
    
        if(repository.getClienteById(id) != null){
            
            Cliente cliente = servico.fromDTO(clienteDTO);
            cliente.setID_Cliente(id);
            cliente = repository.update(cliente);
            return ResponseEntity.ok(cliente);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

