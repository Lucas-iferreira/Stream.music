package br.com.lucas.stream.exception.music;

public class NomeNaoInformadoException extends Exception {
    public NomeNaoInformadoException() {
        super("O nome da sua música não foi informado.");
    }
}
