package br.senac.rn.loja.model;

public class Sexo implements Comparable<Sexo> {

	private Integer id;
	private String nome;
	private String sigla;
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Sexo sexo = (Sexo) obj;
		return this.id.equals(sexo.id);
	}

	@Override
	public String toString() {
		return "Sexo [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}

	@Override
	public int compareTo(Sexo sexo) {
		return this.nome.compareTo(sexo.nome);
	}
	
}
