package br.com.restaurantedoamigao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurantedoamigao.domain.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
	

}