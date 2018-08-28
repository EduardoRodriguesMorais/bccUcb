package br.ucb.managedBean;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.modelo.Candidato;
import br.ucb.modelo.Eleicao;

@ManagedBean(name="eleicaoMB", eager = true)
@ApplicationScoped

public class EleicaoMB implements Serializable{
	private static final long serialVersionUID = 1L;
	private Eleicao eleicao;
	private Candidato vencedor;
	private int voto;
	
	public EleicaoMB() {
		this.eleicao = new Eleicao();
	}
	
	
	public String finalizaEleicao() {
		this.vencedor = new Candidato();
		this.vencedor = this.eleicao.verificaApuracao();
		return "final";
	}
	
	public String votaCandidato() {
		FacesContext fc = FacesContext.getCurrentInstance();
	    Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	    this.voto =  Integer.parseInt(params.get("voto")); 
	    this.eleicao.addVoto();
		switch (this.voto) {
			case 1:
				this.eleicao.getCandidato1().addVoto();
				break;
			case 2:
				this.eleicao.getCandidato2().addVoto();
				break;
			case 3:
				this.eleicao.getCandidato3().addVoto();
				break;
		}
		return "home";
	}

	
	
	
	public Candidato getVencedor() {
		return vencedor;
	}


	public void setVencedor(Candidato vencedor) {
		this.vencedor = vencedor;
	}


	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	
	
}
