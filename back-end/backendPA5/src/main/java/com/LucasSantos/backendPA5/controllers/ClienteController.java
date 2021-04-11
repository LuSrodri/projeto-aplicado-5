package com.LucasSantos.backendPA5.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.LucasSantos.backendPA5.entities.Cliente;
import com.LucasSantos.backendPA5.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
	
    @GetMapping("/getAll")
    public ResponseEntity<Page<Cliente>> getClientesPage(
    		@RequestParam(value = "page",         defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
            @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
            @RequestParam(value = "nome",         defaultValue = "") String nome,
            @RequestParam(value = "cpf",  		  defaultValue = "") String cpf,
            @RequestParam(value = "rg",        	  defaultValue = "") String rg){
    	PageRequest pr = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
    	Page<Cliente> list = service.getClientes(pr,nome.trim(),cpf.trim(),rg.trim());
    	
    	return ResponseEntity.ok().body(list);
    }
    
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente clienteInsert){
		Cliente cliente = service.insert(clienteInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId_Cliente()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente clienteUpdate, @PathVariable Long id){
		Cliente cliente = service.update(id, clienteUpdate); 
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
