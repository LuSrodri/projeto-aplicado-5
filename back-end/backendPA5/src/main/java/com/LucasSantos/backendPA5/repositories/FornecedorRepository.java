package com.LucasSantos.backendPA5.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LucasSantos.backendPA5.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	@Query("SELECT e FROM Fornecedor e " + 
		    "WHERE " +
		    "LOWER(e.nome)     LIKE   LOWER(CONCAT('%', :nome, '%')) AND " +
		    "LOWER(e.cnpj)  LIKE   LOWER(CONCAT('%', :cnpj, '%')) AND " +
		    "LOWER(e.ramo_Atividade)  LIKE   LOWER(CONCAT('%', :ramo_Atividade, '%')) ")
	public Page<Fornecedor> findPage(Pageable pageRequest, String nome, String cnpj, String ramo_Atividade);
	
}
