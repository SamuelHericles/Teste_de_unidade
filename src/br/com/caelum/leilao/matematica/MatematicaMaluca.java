package br.com.caelum.leilao.matematica;

//Classe para verificar se um numero eh maior que 30 ou maior que 10
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
