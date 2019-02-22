package br.com.caelum.leilao.dominio;

public class Lance {

	//Quando usamos o método equals com algumas variáveis,estes atributos devem possuir 
	//uma função hashCode em suas classes.
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lance other = (Lance) obj;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		if(valor<=0) throw new IllegalArgumentException();//valor negativo, lança esta exeção.
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
