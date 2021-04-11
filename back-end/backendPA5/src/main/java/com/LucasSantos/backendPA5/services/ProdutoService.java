package com.LucasSantos.backendPA5.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.LucasSantos.backendPA5.entities.Produto;
import com.LucasSantos.backendPA5.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found"));
	}
	
	public Page<Produto> getProdutos(PageRequest pageRequest, String nome, String categoria, String marca) {

        Page<Produto> list = repository.findPage(pageRequest, nome, categoria, marca);

        return list.map( c -> new Produto());
    }
	
	public Produto insert(Produto obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	public Produto update(Long id, Produto obj) {
		try {
			Produto entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found");
		}
	}

	private void updateData(Produto entity, Produto obj) {
		entity.setNome(obj.getNome());
		entity.setPreco_Custo(obj.getPreco_Custo());
		entity.setPreco_Venda(obj.getPreco_Venda());
		entity.setCategoria(obj.getCategoria());
		entity.setMarca(obj.getMarca());
		entity.setOrigem(obj.getOrigem());
	}
	
}
