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

import com.LucasSantos.backendPA5.entities.Fornecedor;
import com.LucasSantos.backendPA5.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll(){
		return repository.findAll();
	}
	
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor not found"));
	}

	public Page<Fornecedor> getFornecedores(PageRequest pageRequest, String nome, String cnpj, String ramo_atividade) {

        Page<Fornecedor> list = repository.findPage(pageRequest, nome, cnpj, ramo_atividade);

        return list.map( c -> new Fornecedor());
    }
	
	public Fornecedor insert(Fornecedor obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor not found");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	public Fornecedor update(Long id, Fornecedor obj) {
		try {
			Fornecedor entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor not found");
		}
	}

	private void updateData(Fornecedor entity, Fornecedor obj) {
		entity.setRua(obj.getRua());
		entity.setNumero(obj.getNumero());
		entity.setBairro(obj.getBairro());
		entity.setComplemento(obj.getComplemento());
		entity.setCep(obj.getCep());
		entity.setCidade(obj.getCidade());
		entity.setUf(obj.getUf());
		entity.setPais(obj.getPais());
		entity.setTelefone(obj.getTelefone());
		entity.setCelular(obj.getCelular());
		entity.setEmail(obj.getEmail());
	}
	
}
