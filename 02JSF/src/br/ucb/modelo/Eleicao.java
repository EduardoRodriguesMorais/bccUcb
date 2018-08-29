package br.ucb.modelo;

import java.io.Serializable;
import java.util.ArrayList;


public class Eleicao implements Serializable{
	private static final long serialVersionUID = 1L;
	private int qtdVotos;
	private Candidato candidato1 ;
	private Candidato candidato2 ;
	private Candidato candidato3 ;
	private ArrayList<Candidato> candidatos = new ArrayList<>();
	
	public Eleicao() {
		this.candidato1 = new Candidato("Juir Bolsanato","PSC");
		this.candidato2 = new Candidato("Gerardo Aiquimedo","PSDB");
		this.candidato3 = new Candidato("Luiz Quinegócio Molusco da Selva","PT");
		this.addCandidato(candidato1);
		this.addCandidato(candidato2);
		this.addCandidato(candidato3);
	}
	
	public Candidato verificaApuracao() {
		for(Candidato c : this.candidatos) {
			c.setPorcentagemVotos((c.getQtdVotos()*100)/this.getQtdVotos());
		}
		bubbleSort(this.candidatos);
		return this.candidatos.get(0);
	}
	
	public void bubbleSort(ArrayList<Candidato> candidatos) {
		Candidato aux = new Candidato();
		for(int i = 0; i<candidatos.size()-1;i++) {
			for(int j = 1; j<candidatos.size() ;j++) {
				if(candidatos.get(j-1).getQtdVotos() < candidatos.get(j).getQtdVotos()) {
					aux = candidatos.get(j-1);
					candidatos.set(j-1, candidatos.get(j)) ;
					candidatos.set(j,aux);
				}
			}
		}	
	}
	
	
	public void votar(int voto) {
	    this.addVoto();
		switch (voto) {
			case 1:
				this.getCandidato1().addVoto();
				break;
			case 2:
				this.getCandidato2().addVoto();
				break;
			case 3:
				this.getCandidato3().addVoto();
				break;
		}
	}

	
	
	public int getQtdVotos() {
		return qtdVotos;
	}

	public void addVoto() {
		this.qtdVotos += 1;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public void addCandidato(Candidato c) {
		this.candidatos.add(c);
	}
	
	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
	public Candidato getCandidato1() {
		return candidato1;
	}

	public void setCandidato1(Candidato candidato1) {
		this.candidato1 = candidato1;
	}

	public Candidato getCandidato2() {
		return candidato2;
	}

	public void setCandidato2(Candidato candidato2) {
		this.candidato2 = candidato2;
	}

	public Candidato getCandidato3() {
		return candidato3;
	}

	public void setCandidato3(Candidato candidato3) {
		this.candidato3 = candidato3;
	}
}
