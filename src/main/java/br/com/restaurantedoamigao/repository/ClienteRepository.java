package br.com.restaurantedoamigao.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.restaurantedoamigao.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Modifying
	@Query("UPDATE Usuario u SET u.ativo = :ativo, u.dataAtivacao = NOW() WHERE u.email = :email")
	@Transactional
	int ativarDesativar(@Param("ativo") boolean ativo, @Param("email") String email);
	
	Cliente findByEmail(String email);

	Cliente findByEmailAndAtivo(String username, boolean b);

}