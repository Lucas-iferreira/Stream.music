package br.com.lucas.stream.entity;

import br.com.lucas.stream.enums.GeneroMusical;
import br.com.lucas.stream.exception.music.NomeAlbumNaoInformadoException;
import br.com.lucas.stream.exception.music.NomeCantorNaoInformadoException;
import br.com.lucas.stream.exception.music.NomeNaoInformadoException;

public class Musica extends Stream {
    private final GeneroMusical generoMusical;
    private String cantor;
    private String album;

    public Musica(
            String nome,
            String album,
            String generoMusical,
            String cantor
    ) throws NomeNaoInformadoException,
            NomeCantorNaoInformadoException,
            NomeAlbumNaoInformadoException {
        this.setNome(nome);
        this.setCantor(cantor);
        this.setAlbum(album);
        this.generoMusical = GeneroMusical.valueOf(generoMusical);
    }

    public void setCantor(String cantor) throws NomeCantorNaoInformadoException {
        if (cantor.trim().isEmpty()) {
            throw new NomeCantorNaoInformadoException();
        }
        this.cantor = cantor;
    }

    public String getCantor() {
        return cantor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) throws NomeAlbumNaoInformadoException {
        if (album.trim().isEmpty()) {
            throw new NomeAlbumNaoInformadoException();
        }
        this.album = album;
    }

    @Override
    public String toString() {
        return String.format("Música: %s | Album: %s | Categoria: %s | Artista: %s ",
                getNome(),
                getAlbum(),
                generoMusical.getCategoria(),
                getCantor()
        );
    }
}
