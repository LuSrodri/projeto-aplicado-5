package com.LucasSantos.backendPA5.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LucasSantos.backendPA5.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	public List<Pedido> findByData(LocalDate date);
	
}
