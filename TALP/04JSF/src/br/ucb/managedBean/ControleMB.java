package br.ucb.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.modelo.Mercadoria;
import br.ucb.modelo.Usuario;

@ManagedBean
@SessionScoped

public class ControleMB {
	private Mercadoria mercadoria;
	private Usuario usuario;
	private float valor;
	
	public ControleMB(){
		this.mercadoria = new Mercadoria();
		this.usuario = new Usuario();
	}

	
	public String login() {
		
		
		return "calcMercadoria";
	}
	
	public String calcular() {
		
		
		return "resultado";
	}
	
	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
}
