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

import com.LucasSantos.backendPA5.entities.Funcionario;
import com.LucasSantos.backendPA5.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
    @GetMapping("{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id){
        Funcionario funcionario = service.findById(id);
        return ResponseEntity.ok().body(funcionario);
    }
	
    @GetMapping("/getAll")
    public ResponseEntity<Page<Funcionario>> getFuncionariosPage(
    		@RequestParam(value = "page",         defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
            @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
            @RequestParam(value = "nome",         defaultValue = "") String nome,
            @RequestParam(value = "cpf",  		  defaultValue = "") String cpf,
            @RequestParam(value = "rg",        	  defaultValue = "") String rg){
    	PageRequest pr = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
    	Page<Funcionario> list = service.getFuncionarios(pr,nome.trim(),cpf.trim(),rg.trim());
    	
    	return ResponseEntity.ok().body(list);
    }
    
	@PostMapping
	public ResponseEntity<Funcionario> insert(@RequestBody Funcionario funcionarioInsert){
		Funcionario funcionario = service.insert(funcionarioInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId_Funcionario()).toUri();
		return ResponseEntity.created(uri).body(funcionario);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionarioUpdate, @PathVariable Long id){
		Funcionario funcionario = service.update(id, funcionarioUpdate); 
		return ResponseEntity.ok().body(funcionario);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
