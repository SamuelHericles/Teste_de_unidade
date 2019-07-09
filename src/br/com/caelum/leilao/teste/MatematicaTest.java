package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.matematica.MatematicaMaluca;

public class MatematicaTest {
	
	/* A parte mais dificil em desenvolver com testes é quando vamos criar os cenários.
	 * Foque na classe que você está testando, pense sobre o que você esperar dela.Como
	 * ela deve funcionar? Se você passar tais parâmentros para ela,como ela deve reagir?
	 */

	//Testar com numeros maiores que 30
	@Test
	public void deveMultiplicarNumerosMaioresQue30() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(50*4,matematica.contaMaluca(50));
	}

	//Testar com numeros menores que 30 e maiores que 10
	@Test
	public void deveMultiplicarNumerosMaioresQue10EMenoresQue30() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(20*4,matematica.contaMaluca(20));
	}
	
	//Testar para numeros menores que 10
	@Test
	public void deveMultiplicarNumerosMenoresQue10() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(5*2,matematica.contaMaluca(5));
	}
	

	//Testar para numeros negativos
	@Test
	public void deveMultiplicarNumerosMenoresZero() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(0,matematica.contaMaluca(0));
	}
}
