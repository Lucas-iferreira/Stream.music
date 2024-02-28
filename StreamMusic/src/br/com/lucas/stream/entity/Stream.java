package br.com.lucas.stream.entity;

import br.com.lucas.stream.exception.music.NomeNaoInformadoException;

public abstract class Stream {
    protected String nome;

    public Stream() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeNaoInformadoException {
        if (nome.trim().isEmpty()) {
            throw new NomeNaoInformadoException();
        }
        this.nome = nome;
    }
}
