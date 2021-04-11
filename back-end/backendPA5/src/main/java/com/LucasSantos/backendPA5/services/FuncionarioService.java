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

import com.LucasSantos.backendPA5.entities.Funcionario;
import com.LucasSantos.backendPA5.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> findAll(){
		return repository.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario not found"));
	}
	
	public Page<Funcionario> getFuncionarios(PageRequest pageRequest, String nome, String cpf, String rg) {

        Page<Funcionario> list = repository.findPage(pageRequest, nome, cpf, rg);

        return list.map( c -> new Funcionario());
    }
	
	public Funcionario insert(Funcionario obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario not found");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	public Funcionario update(Long id, Funcionario obj) {
		try {
			Funcionario entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario not found");
		}
	}

	private void updateData(Funcionario entity, Funcionario obj) {
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
