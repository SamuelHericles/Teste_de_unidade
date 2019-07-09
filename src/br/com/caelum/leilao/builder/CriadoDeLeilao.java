package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class CriadoDeLeilao {

	/*Esta classe se Test Data Builder - TDB
	 - Tem a especialidade de acplocar os métodos para criação de cenários
	*/
	private Leilao leilao;

	//Cria um leilao a partir de uma string
	public CriadoDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;//devolve o propria classe criador de leilao, assim podemos aninhar métodos para ficar mais simples nosso código.
	}
	
	//Recebe a sequencia de lances ofertados
	public CriadoDeLeilao lance(Usuario usuario,Double valor) {
		leilao.propoe(new Lance(usuario,valor));
		return this;
	}
	
	//Devolve o atributo leilão
	public Leilao constroi() {
		return leilao;
	}
}
