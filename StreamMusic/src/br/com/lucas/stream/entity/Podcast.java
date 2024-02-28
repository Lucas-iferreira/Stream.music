package br.com.lucas.stream.entity;

import br.com.lucas.stream.enums.GeneroPodcast;
import br.com.lucas.stream.exception.podcast.NomeApresentadorNaoInformado;

public class Podcast extends Stream {
    private final GeneroPodcast generoPodcast;
    private String nomeApresentadores;

    public Podcast(String nome,
                   String nomeApresentadores,
                   String generoPodcast
    ) {
        try {
            this.setNome(nome);
            this.setNomeApresentadores(nomeApresentadores);
            this.generoPodcast = GeneroPodcast.valueOf(generoPodcast);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getNomeApresentadores() {
        return nomeApresentadores;
    }

    public void setNomeApresentadores(String nomeApresentadores) throws NomeApresentadorNaoInformado {
        if (nomeApresentadores.trim().isEmpty()) {
            throw new NomeApresentadorNaoInformado();
        }
        this.nomeApresentadores = nomeApresentadores;
    }

    @Override
    public String toString() {
        return String.format(
                "Nome: %s | Apresentado por: %s | Genero: %s ",
                getNome(),
                getNomeApresentadores(),
                generoPodcast.getTipoPodcast()
        );
    }
}
