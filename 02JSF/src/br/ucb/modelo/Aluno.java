package br.ucb.modelo;

import java.io.Serializable;

public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	private float nota1;
	private float nota2;
	private float media;
	private String nome;
	
	public Aluno() {
		
	}
	
	public String verificaAprovacao() {
		if(this.media >= 5 && this.media < 7) {
			return "RECUPERAÇÃO";
		}else if(this.media < 5){
			return "REPROVADO";
		}else{
			return "APROVADO";
		}
	}
	
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getMedia() {
		return media;
	}
	public void setMedia() {
		this.media = (this.nota1 + this.nota2)/2;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
