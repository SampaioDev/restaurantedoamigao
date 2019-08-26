package br.com.restaurantedoamigao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurantedoamigao.domain.Cliente;
import br.com.restaurantedoamigao.service.ClienteService;

@RestController
@RequestMapping("public")
public class PublicController {

	@GetMapping("hello")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok("Hello!");
	}
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("cliente/new")
	public ResponseEntity<Cliente> criarUsuario(@Valid @RequestBody Cliente cliente) {

		return clienteService.salvar(cliente);
	}
	
	@GetMapping("cliente/ativar")
	public ResponseEntity<Cliente> ativarUsuario(@RequestParam String email) {
		
		return clienteService.ativarUsuario(email);
	}
	
	@PostMapping("cliente/resetPassword")
	public ResponseEntity<Cliente> resetarSenha(String email) {
		
		return null;
	}

}