package br.com.caelum.leilao.matematica;

public class MatematicaMaluca {

	public int contaMaluca(int numero) {
		if(numero>30)
			return numero * 4;
		else if(numero>10)
			return numero * 3;
		else
			return 0;
	}
}
