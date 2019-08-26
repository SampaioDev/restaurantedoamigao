package br.com.restaurantedoamigao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.restaurantedoamigao.domain.Cliente;
import br.com.restaurantedoamigao.repository.ClienteRepository;
import br.com.restaurantedoamigao.service.ClienteService;

public class ClienteController {
	private final ClienteRepository repository;
	private final ClienteService usuarioService;
	
	@Autowired
	public ClienteController(ClienteRepository repository, ClienteService usuarioService) {
		this.usuarioService = usuarioService;
		this.repository = repository;
	}
	
	@GetMapping("all")
	public List<Cliente> findAll() {
		
		return repository.findAll();
	}

}
