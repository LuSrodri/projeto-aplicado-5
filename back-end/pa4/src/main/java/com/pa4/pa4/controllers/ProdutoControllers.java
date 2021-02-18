package com.pa4.pa4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pa4.pa4.dto.ProdutoDTO;
import com.pa4.pa4.model.Produto;
import com.pa4.pa4.repository.ProdutoRepository;
import com.pa4.pa4.service.ProdutoService;

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
@RequestMapping("/produtos")
public class ProdutoControllers {
    
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoService servico;

    @GetMapping
    public List<Produto> getProduto(){
        return repository.getAllProdutos();
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int id){
        Produto produto = repository.getProdutoById(id);
        
        if(produto != null)    
            return ResponseEntity.ok(produto);
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ProdutoDTO novoProduto,
                                       HttpServletRequest request,
                                       UriComponentsBuilder builder) {
        Produto produto = repository.salvar(servico.fromDTO(novoProduto));

        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+produto.getID_Produto()).build();

        return ResponseEntity.created(uriComponents.toUri()).build();

    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        Produto produto = repository.getProdutoById(id);
        
        if(produto != null){   
            repository.remove(produto);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable int id, @RequestBody ProdutoDTO produtoDTO){
    
        if(repository.getProdutoById(id) != null){
            
            Produto produto = servico.fromDTO(produtoDTO);
            produto.setID_Produto(id);
            produto = repository.update(produto);
            return ResponseEntity.ok(produto);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

