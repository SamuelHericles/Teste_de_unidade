package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	//CÓDIGO REFATORADO
	//TEST-DRIVEN DEVELOPMENT
	
	/* 
	 * -Se sempre escrevermos o teste antes, garantimos que todo nosso código já "nasce" testado;
	 * 
	 * -Temos segurança para refatorar nosso código, afinal sempre refatoraremos com uma bateria
	 *  de testes que garante que não quebraremos o comportamento já existente;
	 * 
	 * -Como o teste é a primeira classe que usa o seu código, você naturalmente tende a escrever 
	 *  código mais fácil de ser usado e, por consequência, mais fácil de ser mantido.
	 */

	
	/*
	 *  - baby steps: passos pequenos e consissos, para evoluir com base em testes.
	 * - Com o TDD nos deixa pensar cada vez mais simples as implementações.
	 * - Tome passo pequenos sempre quando sua confiança estiver baixa.
	 * - A unica maneira de trabalhar com qualidade e segunraça em código assim é tendo uma bateria de testes que garanta qualquer mundança feita; 
	 */
	
	//para usar o equals melhor, devemso implementar o hashCode na classe que instaciamos
	public void propoe(Lance lance) {
		if (lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}

	private boolean podeDarLance(Usuario usuario) {
		return !extracted().getUsuario().equals(usuario)&& qtdDeLanceDo(usuario) < 5;
	}

	private int qtdDeLanceDo(Usuario usuario) {
		int total = 0;
		for (Lance l : lances) {
			if(l.getUsuario().equals(usuario))total++;
		}
		return total;
	}

	private Lance extracted() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	
	public boolean isBissexto(int ano) {
		if((ano % 4 ==0) && (ano % 100 != 0) ) return true;
		else if ((ano % 400 == 0 )) return true;
		else return false;
	}

}
