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

import com.LucasSantos.backendPA5.entities.Empresa;
import com.LucasSantos.backendPA5.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService service;
	
    @GetMapping("{id}")
    public ResponseEntity<Empresa> getEmpresasById(@PathVariable Long id){
        Empresa empresa = service.findById(id);
        return ResponseEntity.ok().body(empresa);
    }
	
    @GetMapping("/getAll")
    public ResponseEntity<Page<Empresa>> getEmpresaPage(
    		@RequestParam(value = "page",         defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
            @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
            @RequestParam(value = "nome",         defaultValue = "") String nome,
            @RequestParam(value = "cnpj",  		  defaultValue = "") String cnpj,
            @RequestParam(value = "nome_fantasia",defaultValue = "") String nome_fantasia){
    	PageRequest pr = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
    	Page<Empresa> list = service.getEmpresas(pr,nome.trim(),cnpj.trim(),nome_fantasia.trim());
    	
    	return ResponseEntity.ok().body(list);
    }
    
	@PostMapping
	public ResponseEntity<Empresa> insert(@RequestBody Empresa empresaInsert){
		Empresa empresa = service.insert(empresaInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getId_Empresa()).toUri();
		return ResponseEntity.created(uri).body(empresa);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Empresa> update(@RequestBody Empresa empresaUpdate, @PathVariable Long id){
		Empresa empresa = service.update(id, empresaUpdate); 
		return ResponseEntity.ok().body(empresa);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
