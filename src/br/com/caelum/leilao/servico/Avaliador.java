package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double media;

	public void avalia(Leilao leilao){
		for(Lance lance : leilao.getLances()){
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos ) menorDeTodos = lance.getValor();
		}
	}
	
	public void mediaLeilao(Leilao leilao){
		double media = leilao.getLances().stream().mapToDouble(Integer::valor).average().orElse(0.0);
	}
	
	public double getMenorDeTodos() {
		return menorDeTodos;
	}

	public void setMenorDeTodos(double menorDeTodos) {
		this.menorDeTodos = menorDeTodos;
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}
	
	public void setMaiorDeTodos(double maiorDeTodos) {
		this.maiorDeTodos = maiorDeTodos;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

}
