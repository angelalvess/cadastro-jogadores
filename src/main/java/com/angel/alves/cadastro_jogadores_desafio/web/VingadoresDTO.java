package com.angel.alves.cadastro_jogadores_desafio.web;

import java.util.List;

public record VingadoresDTO(
        List<Codename> vingadores
) implements  CodenameDTO{

    public List<String> getCodenames(){
        return vingadores.stream().map(Codename::codinome).toList();
    }

}

record Codename(String codinome){}
