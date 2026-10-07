package com.joyce.rpg;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
	private List<Equipamento> estoque;

	public Loja() {
		super();
		this.estoque = new ArrayList<>();
		carregarEstoque();
	}
	private void carregarEstoque() {
		for(TipoEquipamento tipo : TipoEquipamento.values()) {
			
			Equipamento novoItem = new Equipamento(tipo);
			this.estoque.add(novoItem);
			
		}
	}
	
	public void abrirLoja(Jogador jogador, Scanner leitor) {
		
		int opcao = - 1;
		while(opcao != 0) {
			
			System.out.println("------- MENU DA LOJA -------");
			System.out.println("Moedas em inventario: " + jogador.getOuro());
			for(int i = 0; i < estoque.size(); i++) {
				Equipamento item = estoque.get(i);
				System.out.println((i +1) + "-" + item.getNome() + " preço: " + item.getValor() + ".");
			}
			System.out.println("0- Sair da loja. ");
			System.out.print("Escolha uma das opções: ");
			opcao = leitor.nextInt();
			
			if(opcao > 0 && opcao <= estoque.size()) {
				
				Equipamento itemSelecionado = estoque.get(opcao - 1);
				if(jogador.getOuro() >= itemSelecionado.getValor()) {
					jogador.setOuro((int) (jogador.getOuro() - itemSelecionado.getValor()));
					jogador.getInventario().adicionarItem(itemSelecionado);
					System.out.println("Compra realizada! " + itemSelecionado.getNome() + ".");
				}else {
					System.out.println("Você não tem moedas o suficiente! Para comprar: " + itemSelecionado.getNome() + ".");
				}
			}else if(opcao != 0) {
				System.out.println("Opção invalida! ");
			}
		}
		System.out.println("Já vai? até logo então.");
	}	
	public List<Equipamento> getEstoque() {
		return estoque;
	}
	public void setEstoque(List<Equipamento> estoque) {
		this.estoque = estoque;
	}

}
