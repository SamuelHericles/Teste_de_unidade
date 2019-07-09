package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.builder.CriadoDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	
	/*
	
	     TDD- podemos testar primeiro a classe com métodos brutos e depois de dar 
	 certo podemos refatorar o código para deixá-lo mais refinados
	
	*/

	/*
	 * TDD é uma pratica de desenvolvimento em que construimos os testes antes do código.
	 */

	//Testar para um lance simples
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0,leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"),2000));
		
		assertEquals(1,leilao.getLances().size());
		assertEquals(2000,leilao.getLances().get(0).getValor(),0.00001);
	}

	//Testar para receber varios lances
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new CriadoDeLeilao().para("Mackbook Pro 15")
				.lance(new Usuario("Steve Jobs"),2000.00)
				.lance(new Usuario("Steve Wozniak"),3000.00)
				.constroi();
		
		assertEquals(2,leilao.getLances().size());
		assertEquals(2000,leilao.getLances().get(0).getValor(),0.00001);
		assertEquals(3000,leilao.getLances().get(1).getValor(),0.00001);
	}
	

	//Testar para não receber dois lances seguindos do mesmo usuario
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new CriadoDeLeilao().para("Mackbook Pro 15")
				.lance(new Usuario("Steve Jobs"), 2000.00)
				.lance(new Usuario("Steve Jobs"), 3000.00)
				.constroi();
		
		assertEquals(1,leilao.getLances().size());
	    assertEquals(2000,leilao.getLances().get(0).getValor(),0.00001);
	}
	

	//Testar para não mais do que cinco lances
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Mackbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");
		
		leilao.propoe(new Lance(steveJobs,2000));
		leilao.propoe(new Lance(billGates,3000));
		
		leilao.propoe(new Lance(steveJobs,4000));
		leilao.propoe(new Lance(billGates,5000));
		
		leilao.propoe(new Lance(steveJobs,6000));
		leilao.propoe(new Lance(billGates,7000));
		
		leilao.propoe(new Lance(steveJobs,8000));
		leilao.propoe(new Lance(billGates,9000));

		leilao.propoe(new Lance(steveJobs,10000));
		leilao.propoe(new Lance(billGates,11000));

		leilao.propoe(new Lance(steveJobs,12000));
		
		
		assertEquals(10,leilao.getLances().size());
		int ultimo = leilao.getLances().size()-1;
		Lance ultimoLance = leilao.getLances().get(ultimo);
		assertEquals(11000.0,ultimoLance.getValor(),0.00001);

	}
	

	//Testar para saber se o seguinte ano eh bissexto ou não
	@Test
	public void deveRetornarBissexto(){
		Leilao anoBissexto = new Leilao("Teste");
		assertEquals(true,anoBissexto.isBissexto(2016));
		assertEquals(true,anoBissexto.isBissexto(2012));
	}

	//Testar para saber se o ano não é bissexto
	@Test
	public void naoDeveRetornarBissexto(){
		Leilao anoBissexto = new Leilao("Teste");
		assertEquals(false,anoBissexto.isBissexto(2015));
		assertEquals(false,anoBissexto.isBissexto(2011));
	}

	//Testar para uma execeção
	@Test(expected=IllegalArgumentException.class)
	public void deveRecusarLancesComValorDeZero(){
		new Lance(new Usuario("Jhon Doe"),0);
	}
	

	//Testar para uma execeção
	@Test(expected=IllegalArgumentException.class)
	public void deveRecursarLancesComValorNegativo() {
		new Lance(new Usuario("Jhon Doe"),-10);
	}
	
}

