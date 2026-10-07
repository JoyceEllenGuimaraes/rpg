package com.joyce.rpg;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioJogo {
	private static Clip musicaFundo;
	public static void tocarSom(String nomeArquivo) {
		try {
			String caminhoFormatado = "/sons/" + nomeArquivo;
			URL url = AudioJogo.class.getResource(caminhoFormatado);
			if (url != null) {
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} else {
				System.out.println("Arquivo de áudio não encontrado em: " + caminhoFormatado);
			}
		} catch (Exception e) {
			System.out.println("Erro ao reproduzir o som: " + e.getMessage());
		}
	}
	public static void tocarMusicaFundo(String nomeArquivo) {
		try {
			String caminhoFormatado = "/sons/" + nomeArquivo;
			URL url = AudioJogo.class.getResource(caminhoFormatado);
			if(url != null) {
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
				musicaFundo = AudioSystem.getClip();
				musicaFundo.open(audioStream);
				musicaFundo.loop(Clip.LOOP_CONTINUOUSLY);
			}else {
				System.out.println("Arquivo de audio não encontrado em: " + caminhoFormatado);
			} 
		} catch (Exception e) {
			System.out.println("Erro ao reproduzir música de fundo: " + e.getMessage());
		}
	}
	public static void pararMusicaFundo() {
		if(musicaFundo != null && musicaFundo.isRunning()) {
			musicaFundo.stop();
			musicaFundo.close();
		}
	}
}