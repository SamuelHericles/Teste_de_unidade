package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	//Variaveis da classe, configara para ter o maior e o menor numero possivel pelo java
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;

	//Saber qual o menor lance de todos
	public void avalia(Leilao leilao) {
		
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possivel fazer um leilão sem lances!");
		}
		
		for(Lance lance: leilao.getLances()) {
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
		}
		pegaOsMaioresNo(leilao);
	}
	
	
	/*
	 * Um leilão com 5 lances, deve encontrar os três maiores
	 * Um leilão com 2 lances, deve devolver os dois lances que encontrou
	 * Um leilão sem nenhum lance, devolve lista vazia.
	 */

	//Inserir na variavel 'maiores' o maior lance ofertado
	public void pegaOsMaioresNo(Leilao leilao) {
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores,new Comparator<Lance>() {
			public int compare(Lance o1,Lance o2) {
				if(o1.getValor() < o2.getValor()) return 1; 
				if(o1.getValor() > o2.getValor()) return -1;
				return 0;
			}
		});
			maiores = maiores.subList(0, maiores.size() > 3 ? 3 :maiores.size());
	}
	
	//Retornar uma lista dos três maiores lances
	public List<Lance> getTresMaiores(){
		return this.maiores;
	}
	
	//Obter o maior lance
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	//Obter o menor lance
	public double getMenorLance() {
		return menorDeTodos;
	}
}