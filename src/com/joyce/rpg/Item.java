package com.joyce.rpg;
import java.io.Serializable;
public abstract class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private int valor;
	
	public Item(String nome, String descricao, int valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public abstract void usar(Jogador jogador);

}
