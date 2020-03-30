package model;

public class Pais {

	private long id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais() {}
	
	public Pais(long id, String nome, long populacao, double area) {
		setNome(nome);
		setPopulacao(populacao);
		setArea(area);
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "{Id: " + getId() + " Nome: " + getNome() + 
				" População: " + getPopulacao() + " Area: " + getArea() + "}";
	}
}
