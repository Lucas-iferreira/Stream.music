package br.com.lucas.stream.menu;

import br.com.lucas.stream.exception.music.NomeArquivoNaoInformadoException;
import br.com.lucas.stream.exception.music.NomeNaoInformadoException;
import br.com.lucas.stream.exception.podcast.NomePodcastNaoInformado;
import br.com.lucas.stream.service.MusicService;
import br.com.lucas.stream.service.PodcastService;

import java.util.Scanner;

public class Menu {
    MusicService musicService;
    PodcastService podcastService;
    Scanner scanner = new Scanner(System.in);

    String menuOpcao = """
            =*=*=*=*=*=*=*Menu*=*=*=*=*=*=*=*=*
            =*=*=*=*=*=*Reproduções!=*=*=*=*=*=
            =*=*=*=*=Escolha uma opção*=*=*=*=*
            1 - Musicas
            2 - Podcasts
            0 - Sair
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
            """;
    String menuOpcaoMusica = """
            =*=*=*=*=*=*=*Menu*=*=*=*=*=*=*=*=*
            =*=*=*=*=*=*=Musica=*=*=*=*=*=*=*=*
            1 - Adicione uma musica em sua playlist
            2 - Mostre a playlist de musicas
            3 - Remova uma musica da sua playlist
            4 - Procure uma musica pelo nome
            5 - Compartilhar playlist
            0 - Menu anterior
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
                        
            """;
    String menuOpcaoPodcast = """
            =*=*=*=*=*=*=*Menu*=*=*=*=*=*=*=*=*
            =*=*=*=*==*=*Podcast*=*=*=*=*=*=*=*
            1 - Adicione um Podcast em sua lista
            2 - Mostre a lista
            3 - Remova um Podcast da lista
            4 - Procure um podcast pelo nome
            5 - Compartilhar Lista de Podcast
            0 - Menu Anterior
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
            =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=
                        
            """;
    Integer opcao = null;

    public Menu(MusicService musicService, PodcastService podcastService) {
        this.musicService = musicService;
        this.podcastService = podcastService;

    }

    public void menuPrincipal() {
        do {
            System.out.println(menuOpcao);
            System.out.println("opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido!");
                scanner.next();
                System.out.println("opção: ");
            }
            opcao = scanner.nextInt();
            if (opcao < 0 || opcao > 2) {
                System.out.println("Opção inálida!");
            }
            switch (opcao) {
                case 1:
                    menuMusica();
                    break;
                case 2:
                    menuPodcast();
                    break;
                case 0:
                    System.out.println("Encerrando o programa!");
                    return;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public void menuMusica() {
        do {
            System.out.println(menuOpcaoMusica);
            System.out.print("opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido!");
                scanner.next();
                System.out.println("opção: ");
            }
            opcao = scanner.nextInt();
            if (opcao < 0 || opcao > 5) {
                System.out.println("Opção invalida");
            }
            try {
                switch (opcao) {
                    case 1:
                        musicService.inserir();
                        break;
                    case 2:
                        musicService.obterTodasAsMusicas();
                        break;
                    case 3:
                        musicService.removerMusicaPeloNome();
                        break;
                    case 4:
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Digite o nome da música que deseja procurar:");
                        String nomeDaMusica = scanner1.nextLine();
                        System.out.println(musicService.procurarMusicaPeloNome(nomeDaMusica));
                        break;
                    case 5:
                        musicService.compartilharPlaylist();
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        break;
                }
            } catch (NomeNaoInformadoException e) {
                System.out.println("Nome da música não informada");
            } catch (NomeArquivoNaoInformadoException e) {
                System.out.println("Nome do arquivo não informado!");
            }
        } while (opcao != 0);
    }

    public void menuPodcast() {
        do {
            System.out.println(menuOpcaoPodcast);
            System.out.println("opção:");

            while (!scanner.hasNextInt()) {
                System.out.println("por favor, insira um número válido");
                scanner.next();
                System.out.println("opção: ");
            }
            opcao = scanner.nextInt();
            if (opcao < 0 || opcao > 5) {
                System.out.println("Opcao inválida");
            }
            try {
                switch (opcao) {
                    case 1:
                        podcastService.inserir();
                        break;
                    case 2:
                        podcastService.ObterListaPodcast();
                        break;
                    case 3:
                        podcastService.removerPodcastLista();
                        break;
                    case 4:
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Digite o nome do podcast que deseja procurar:");
                        String nomeDaMusica = scanner1.nextLine();
                        System.out.println(podcastService.procurarPodcastPeloNome(nomeDaMusica));
                        break;
                    case 5:
                        podcastService.compartilharListaPodcast();
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        break;
                }
            } catch (NomePodcastNaoInformado e) {
                System.out.println("Nome do Podcast não informado!");
            } catch (NomeArquivoNaoInformadoException e) {
                System.out.println("Nome do arquivo não informado!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (opcao != 0);
    }

}
