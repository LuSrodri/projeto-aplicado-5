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

import com.LucasSantos.backendPA5.entities.Fornecedor;
import com.LucasSantos.backendPA5.services.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService service;
	
    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id){
        Fornecedor fornecedor = service.findById(id);
        return ResponseEntity.ok().body(fornecedor);
    }
	
    @GetMapping("/getAll")
    public ResponseEntity<Page<Fornecedor>> getFornecedoresPage(
    		@RequestParam(value = "page",          defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",  defaultValue = "6") Integer linesPerPage,
            @RequestParam(value = "direction",     defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy",       defaultValue = "id") String orderBy,
            @RequestParam(value = "nome",          defaultValue = "") String nome,
            @RequestParam(value = "cnpj",  		   defaultValue = "") String cnpj,
            @RequestParam(value = "ramo_atividade",defaultValue = "") String ramo_atividade){
    	PageRequest pr = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
    	Page<Fornecedor> list = service.getFornecedores(pr,nome.trim(),cnpj.trim(),ramo_atividade.trim());
    	
    	return ResponseEntity.ok().body(list);
    }
    
	@PostMapping
	public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor fornecedorInsert){
		Fornecedor fornecedor = service.insert(fornecedorInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedor.getId_Fornecedor()).toUri();
		return ResponseEntity.created(uri).body(fornecedor);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Fornecedor> update(@RequestBody Fornecedor fornecedorUpdate, @PathVariable Long id){
		Fornecedor fornecedor = service.update(id, fornecedorUpdate); 
		return ResponseEntity.ok().body(fornecedor);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
