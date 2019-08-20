package br.com.restaurantedoamigao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurantedoamigao.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	

}