package br.ucb.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String senha;
	
	public Usuario () {
		
	}
	
	public Usuario (String nome, String senha) {
		this.setNome(nome);
		this.setSenha(senha);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
