package com.LucasSantos.backendPA5.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LucasSantos.backendPA5.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT e FROM Cliente e " + 
		    "WHERE " +
		    "LOWER(e.nome)     LIKE   LOWER(CONCAT('%', :nome, '%')) AND " +
		    "LOWER(e.cpf)  LIKE   LOWER(CONCAT('%', :cpf, '%')) AND " +
		    "LOWER(e.rg)  LIKE   LOWER(CONCAT('%', :rg, '%')) ")
	public Page<Cliente> findPage(Pageable pageRequest, String nome, String cpf, String rg);
			
}