package com.joyce.rpg;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GeradorInimigo {
	public static List<Monstro> inimigosGeradoSala(int sala){

		List<Monstro> grupo = new ArrayList<Monstro>();
		Random random = new Random();

		int quantidadeInimigo = Math.min(sala, 5);

		for(int i = 0; i < quantidadeInimigo; i++) {
			TipoMonstro[] opcaoMonstro = TipoMonstro.values();
			TipoMonstro tipoSorteado =  opcaoMonstro[random.nextInt(opcaoMonstro.length)];
			Monstro inimigo = new Monstro(tipoSorteado);
			
			if(Math.random() <= 0.3){
				TipoEquipamento[] opcoesEquipamento = TipoEquipamento.values();
				TipoEquipamento equipamentoSorteado = opcoesEquipamento[random.nextInt(opcoesEquipamento.length)];
				inimigo.setEquipamento(new Equipamento(equipamentoSorteado));
			}
			grupo.add(inimigo);
		}
		return grupo;
	}
	public static Boss geradorSorteioBoss() {
		Random random = new Random();
		TipoBoss[] chefesPossiveis = TipoBoss.values();
		TipoBoss bossSorteado = chefesPossiveis[random.nextInt(chefesPossiveis.length)];
		return new Boss(bossSorteado.name(), bossSorteado);
	}

}
