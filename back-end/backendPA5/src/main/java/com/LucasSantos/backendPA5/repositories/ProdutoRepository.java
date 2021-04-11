package com.LucasSantos.backendPA5.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LucasSantos.backendPA5.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT e FROM Produto e " + 
		    "WHERE " +
		    "LOWER(e.nome)     LIKE   LOWER(CONCAT('%', :nome, '%')) AND " +
		    "LOWER(e.categoria)  LIKE   LOWER(CONCAT('%', :categoria, '%')) AND " +
		    "LOWER(e.marca)  LIKE   LOWER(CONCAT('%', :marca, '%')) ")
	public Page<Produto> findPage(Pageable pageRequest, String nome, String categoria, String marca);
	
}
