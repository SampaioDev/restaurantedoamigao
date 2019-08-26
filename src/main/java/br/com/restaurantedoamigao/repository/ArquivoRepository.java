package br.com.restaurantedoamigao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurantedoamigao.domain.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
	
	List<Arquivo> findByIdProcesso(Long idProcesso);

}