package br.ucb.modelo;

public class Mercadoria {
	private String nome;
	private float preco;
	
	public Mercadoria () {
		
	}
	
	public Mercadoria (String nome, float preco) {
		this.setNome(nome);
		this.setPreco(preco);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	
}
