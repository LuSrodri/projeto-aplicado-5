package com.LucasSantos.backendPA5.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LucasSantos.backendPA5.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT e FROM Empresa e " + 
		    "WHERE " +
		    "LOWER(e.nome)     LIKE   LOWER(CONCAT('%', :nome, '%')) AND " +
		    "LOWER(e.cnpj)  LIKE   LOWER(CONCAT('%', :cnpj, '%')) AND " +
		    "LOWER(e.nome_Fantasia)  LIKE   LOWER(CONCAT('%', :nome_Fantasia, '%')) ")
	public Page<Empresa> findPage(Pageable pageRequest, String nome, String cnpj, String nome_Fantasia);
	
}
