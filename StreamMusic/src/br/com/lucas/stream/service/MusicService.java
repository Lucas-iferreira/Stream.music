package br.com.lucas.stream.service;

import br.com.lucas.stream.entity.Musica;
import br.com.lucas.stream.exception.music.NomeArquivoNaoInformadoException;
import br.com.lucas.stream.exception.music.NomeNaoInformadoException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MusicService {

    private final List<Musica> playlist;
    private final Scanner scanner;

    public MusicService() {
        this.playlist = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }


    public void inserir() {
        try {
            System.out.print("Digite o nome da música que deseja adicionar:");
            String nome = scanner.nextLine();

            System.out.print("Digite o nome do album:");
            String album = scanner.nextLine();

            System.out.println("Digite o genero musical:");
            System.out.println("ROCK, CLASSICA, RAP, MPB, PAGODE, SERTANEJO");
            String genero = scanner.nextLine();

            System.out.print("Digite o nome do artista:");
            String artista = scanner.nextLine();

            Musica musica = new Musica(nome, album, genero.toUpperCase(), artista);
            playlist.add(musica);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void obterTodasAsMusicas() {
        for (Musica musica : playlist) {
            System.out.println(musica);
        }
    }

    public Musica procurarMusicaPeloNome(String nome) throws NomeNaoInformadoException {
        Optional<Musica> musicaOptional = playlist.
                stream().filter(
                        musica -> musica.getNome().equalsIgnoreCase(nome)).findFirst();
        if (musicaOptional.isEmpty()) {
            throw new NomeNaoInformadoException();
        }
        return musicaOptional.get();
    }

    public void removerMusicaPeloNome() throws NomeNaoInformadoException {
        System.out.println("Digite o nome da musica");
        String musica = scanner.nextLine();
        playlist.remove(procurarMusicaPeloNome(musica));
        System.out.println("Música removida com sucesso!");
    }

    public void compartilharPlaylist() throws NomeArquivoNaoInformadoException {
        System.out.println("Digite o nome da sua Playlist:");
        String nomeDoArquivo = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter(nomeDoArquivo + ".txt");
            for (Musica musica : playlist) {
                writer.write(musica + "\n");
            }
            writer.close();


        } catch (IOException e) {
            throw new NomeArquivoNaoInformadoException();
        }
        scanner.close();
    }
}
