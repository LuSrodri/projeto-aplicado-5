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

import com.LucasSantos.backendPA5.entities.Produto;
import com.LucasSantos.backendPA5.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
    @GetMapping("{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }
	
    @GetMapping("/getAll")
    public ResponseEntity<Page<Produto>> getProdutosPage(
    		@RequestParam(value = "page",         defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
            @RequestParam(value = "direction",    defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,
            @RequestParam(value = "nome",         defaultValue = "") String nome,
            @RequestParam(value = "categoria",	  defaultValue = "") String categoria,
            @RequestParam(value = "marca",     	  defaultValue = "") String marca){
    	PageRequest pr = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
    	Page<Produto> list = service.getProdutos(pr,nome.trim(),categoria.trim(),marca.trim());
    	
    	return ResponseEntity.ok().body(list);
    }
    
	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto produtoInsert){
		Produto produto = service.insert(produtoInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId_Produto()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Produto> update(@RequestBody Produto produtoUpdate, @PathVariable Long id){
		Produto produto = service.update(id, produtoUpdate); 
		return ResponseEntity.ok().body(produto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
