package br.com.restaurantedoamigao.service;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.restaurantedoamigao.domain.Cliente;
import br.com.restaurantedoamigao.dto.Email;
import br.com.restaurantedoamigao.repository.ClienteRepository;

public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EmailService emailService;
	
	private PasswordEncoder passEncoder = new BCryptPasswordEncoder();

	public ResponseEntity<Cliente> salvar(Cliente cliente) {
		
		Cliente clienteSalvo = repository.findByEmail(cliente.getEmail());
		
		if (clienteSalvo != null)
			return ResponseEntity.badRequest().build();
		
		enviaEmailCadastro(cliente);
		
		cliente.setPassword(convertPassToBcrypt(cliente.getPassword()));
		repository.save(cliente);
		
		return ResponseEntity.ok().build();
	}
	
	private void enviaEmailCadastro(Cliente cliente) {
		Email email = new Email();
		email.setAssunto("Restaurante do Amigão - Confirme seu email");
		email.setEmailDestinatario(cliente.getEmail());
		email.setNomeDestinatario(cliente.getNome());
		email.setMensagem("Olá, " + cliente.getNome()
					+ "\n\nSeja bem-vindo ao Restaurante do Amigão,"
					+ "\nPara confirmar seu e-mail, clique no link abaixo:"
					+ "\nhttp://localhost:8080/public/usuario/ativar?email=" + cliente.getEmail());
		
		
		try {
			emailService.enviarAssincrono(email);
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
	}

	public String convertPassToBcrypt(String textoPlano) {
		return passEncoder.encode(textoPlano);
	}
	
	/*private String criarSenhaAleatoria() {
		int[] letras = new int[62];
		int start = 48;
		for (int i = 0; i < letras.length; i++) {
			while ((start > 57 && start < 65) || (start > 90 && start < 97))
				start++;
			letras[i] = start++;
		}
	    int targetStringLength = 8;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomInt = (int) (random.nextFloat() * 52);
	        buffer.append((char) letras[randomInt]);
	    }
	    String generatedString = buffer.toString();
	    
	    return generatedString;
	}*/

	public Cliente getByEmail(String email) {
		
		return repository.findByEmail(email);
	}
	
	public ResponseEntity<Cliente> ativarUsuario(String email) {
		int rows = repository.ativarDesativar(true, email);
		
		return rows > 0 ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}