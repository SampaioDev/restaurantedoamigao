package br.com.restaurantedoamigao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {

	@GetMapping("hello")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok("Hello!");
	}
	
}
