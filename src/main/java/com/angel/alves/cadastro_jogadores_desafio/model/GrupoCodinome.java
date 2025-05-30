package com.angel.alves.cadastro_jogadores_desafio.model;

public enum GrupoCodinome {

    VINGADORES("Os Vingadores", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    LIGA_DA_JUSTICA("A Liga da Justiça","https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    private String name;
    private String uri;

    GrupoCodinome(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
}
