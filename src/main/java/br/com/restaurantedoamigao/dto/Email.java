package br.com.restaurantedoamigao.dto;

public class Email {
	
	private String emailDestinatario;
	private String nomeDestinatario;
	private String assunto;
	private String mensagem;

	public String getCorpoEmail() {
		return "";
	}

	public String getAssunto() {
		return "Restaurante do Amigão - " + assunto;
	}

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}