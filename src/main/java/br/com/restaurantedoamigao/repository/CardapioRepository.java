package br.com.restaurantedoamigao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurantedoamigao.domain.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
	

}