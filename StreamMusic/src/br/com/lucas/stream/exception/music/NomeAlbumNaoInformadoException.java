package br.com.lucas.stream.exception.music;

public class NomeAlbumNaoInformadoException extends Exception {
    public NomeAlbumNaoInformadoException() {
        super("O album não foi informado!");
    }
}
