package br.com.lucas.stream.service;

import br.com.lucas.stream.entity.Podcast;
import br.com.lucas.stream.exception.music.NomeArquivoNaoInformadoException;
import br.com.lucas.stream.exception.podcast.NomePodcastNaoInformado;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PodcastService {
    private final List<Podcast> listaDePodcast;
    private final Scanner scanner;

    public PodcastService() {
        this.listaDePodcast = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void inserir() {
        try {
            System.out.print("Digite o nome do Podcast: ");
            String nomePodcast = scanner.nextLine();

            System.out.print("Apresentado por: ");
            String nomeApresentador = scanner.nextLine();

            System.out.println("Digite o genero do podcast: ");
            System.out.println("HUMOR | INVESTIGATIVO | NEGOCIOS | EDUCAÇÃO | NOTICIAS: ");
            String generoPodcast = scanner.nextLine();

            Podcast podcast = new Podcast(nomePodcast, nomeApresentador, generoPodcast.toUpperCase());
            listaDePodcast.add(podcast);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void ObterListaPodcast() {
        for (Podcast podcast : listaDePodcast) {
            System.out.println(podcast);
        }
    }

    public Podcast procurarPodcastPeloNome(String nome) throws NomePodcastNaoInformado {
        Optional<Podcast> podcastOptional = listaDePodcast.
                stream().filter(
                        podcast -> podcast.getNome().equalsIgnoreCase(nome)).findFirst();
        if (podcastOptional.isEmpty()) {
            throw new NomePodcastNaoInformado();
        }
        return podcastOptional.get();
    }

    public void removerPodcastLista() throws Exception {
        System.out.print("Digite o Podcast que deseja remover: ");
        String nomePodcast = scanner.nextLine();
        listaDePodcast.remove(procurarPodcastPeloNome(nomePodcast));
        System.out.println("Podcast excluído com sucesso!");

    }

    public void compartilharListaPodcast() throws NomeArquivoNaoInformadoException {
        System.out.println("Digite o nome da lista de Podccast: ");
        String nomeArquivo = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter(nomeArquivo + ".txt");
            for (Podcast podcast : listaDePodcast) {
                writer.write(podcast + "\n");
            }
            writer.close();
        } catch (Exception e) {
            throw new NomeArquivoNaoInformadoException();
        }
    }

}
