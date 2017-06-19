package br.com.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

	private String mensagem = "Essa mensagem veio do bean";
	private String nome = null;
	
	public String botaoClicado() {
		System.out.println("O botão foi clicado");
		System.out.println("Seu nome é: " + nome);
		return null;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
