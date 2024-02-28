package br.com.lucas.stream.enums;

public enum GeneroPodcast {
    HUMOR("HUMOR"),
    INVESTIGATIVO("INVESTIGATIVO"),
    NEGOCIOS("NEGOCIOS"),
    EDUCAÇAO("EDUCAÇÃO"),
    NOTICIAS("NOTICIAS");

    private final String tipoPodcast;

    GeneroPodcast(String tipoPodcast) {
        this.tipoPodcast = tipoPodcast;
    }

    public String getTipoPodcast() {
        return tipoPodcast;
    }
}
