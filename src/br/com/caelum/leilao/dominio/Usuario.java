package br.com.caelum.leilao.dominio;

public class Usuario {
	
	//Variaveis da classe
	private int id;
	private String nome;
	
	//Primeiro construtor da classe usuário
	public Usuario(String nome) {
		this(0, nome);
	}

	/*
	     Quando usamos o método 'equals' com algumas variáveis,estes atributos devem possuir 
	 uma função hashCode em suas classes.
	*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	//Segundo construtor da classe usuário
	public Usuario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	//Obter o id do usuário
	public int getId() {
		return id;
	}

	//Obter o nome do usuário
	public String getNome() {
		return nome;
	}
	
	
	
}
