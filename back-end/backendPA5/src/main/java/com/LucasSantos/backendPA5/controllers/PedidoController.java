package com.LucasSantos.backendPA5.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.LucasSantos.backendPA5.entities.Pedido;
import com.LucasSantos.backendPA5.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
    @GetMapping("{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id){
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }
	
    @GetMapping("/getByData")
    public ResponseEntity<List<Pedido>> getPedidoByData(@RequestParam(value = "Data", defaultValue = "") String data){
    	LocalDate sDate = LocalDate.parse(data);
    	
    	List<Pedido> list = service.findByData(sDate);
    	return ResponseEntity.ok().body(list);
    }
    
	@PostMapping
	public ResponseEntity<Pedido> insert(@RequestBody Pedido pedidoInsert){
		Pedido pedido = service.insert(pedidoInsert);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId_Pedido()).toUri();
		return ResponseEntity.created(uri).body(pedido);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
	
}
