package br.ucb.modelo;

import java.io.Serializable;

public class Candidato implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String partido; 
	private int qtdVotos;
	
	public Candidato() {
		
	}
	
	public Candidato(String nome, String partido){
		this.setNome(nome);
		this.setPartido(partido);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getQtdVotos() {
		return qtdVotos;
	}
	public void addVoto() {
		this.qtdVotos += 1;
	}
	
	
}
