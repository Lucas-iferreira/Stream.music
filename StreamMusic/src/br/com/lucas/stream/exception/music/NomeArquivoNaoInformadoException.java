package br.com.lucas.stream.exception.music;

public class NomeArquivoNaoInformadoException extends Exception {
    public NomeArquivoNaoInformadoException() {
        super("Errou ao criar arquivo");
    }
}
