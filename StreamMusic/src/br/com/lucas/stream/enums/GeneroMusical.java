package br.com.lucas.stream.enums;

public enum GeneroMusical {
    ROCK("ROCK"),
    CLASSICA("CLASSICA"),
    RAP("RAP"),
    MPB("MPB"),
    PAGODE("PAGODE"),
    SERTANEJO("SERTANEJO");

    private final String categoriaMusical;

    GeneroMusical(String categoria) {
        this.categoriaMusical = categoria;
    }

    public String getCategoria() {
        return categoriaMusical;
    }

}
