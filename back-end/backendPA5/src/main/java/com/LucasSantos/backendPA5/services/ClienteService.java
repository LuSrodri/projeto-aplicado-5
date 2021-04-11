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

import com.LucasSantos.backendPA5.entities.Cliente;
import com.LucasSantos.backendPA5.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found"));
	}
	
	public Page<Cliente> getClientes(PageRequest pageRequest, String nome, String cpf, String rg) {

        Page<Cliente> list = repository.findPage(pageRequest, nome, cpf, rg);

        return list.map( c -> new Cliente());
    }
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found");
		}
	}

	private void updateData(Cliente entity, Cliente obj) {
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
