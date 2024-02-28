package br.com.lucas.stream.exception.podcast;

public class NomeApresentadorNaoInformado extends Exception {
    public NomeApresentadorNaoInformado() {
        super("O campo não pode ser vazio, digite o nome do apresentador!");
    }
}
