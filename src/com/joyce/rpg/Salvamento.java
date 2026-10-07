package com.joyce.rpg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Salvamento {

	private static final String ARQUIVO_SAVE = "save_jogo.dat";
	public static boolean salvarJogo(Jogador jogador) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_SAVE))) {
			oos.writeObject(jogador);
			System.out.println("\n Jogo salvo com sucesso!");
			return true;
		} catch (IOException e) {
			System.out.println("\n Erro ao salvar o jogo: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public static Jogador carregarJogo() {
		File arquivo = new File(ARQUIVO_SAVE);
		if (!arquivo.exists()) {
			System.out.println("Nenhum arquivo de save encontrado.");
			return null;
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_SAVE))) {
			Jogador jogador = (Jogador) ois.readObject();
			System.out.println("\n Progresso de " + jogador.getNome() + " carregado com sucesso!");
			return jogador;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("\n Erro ao carregar o arquivo de save: " + e.getMessage());
			return null;
		}
	}
}
