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

import com.LucasSantos.backendPA5.entities.Empresa;
import com.LucasSantos.backendPA5.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> findAll(){
		return repository.findAll();
	}
	
	public Empresa findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa not found"));
	}
	
	public Page<Empresa> getEmpresas(PageRequest pageRequest, String nome, String cnpj, String nome_fantasia) {

        Page<Empresa> list = repository.findPage(pageRequest, nome, cnpj, nome_fantasia);

        return list.map( c -> new Empresa());
    }
	
	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa not found");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	public Empresa update(Long id, Empresa obj) {
		try {
			Empresa entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa not found");
		}
	}

	private void updateData(Empresa entity, Empresa obj) {
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
		entity.setFilial(obj.getFilial());
		entity.setPorte(obj.getPorte());
	}
	
}
