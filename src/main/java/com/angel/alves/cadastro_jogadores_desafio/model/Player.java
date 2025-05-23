package com.angel.alves.cadastro_jogadores_desafio.model;

public record Player(
        String name,
        String email,
        String telephone,
        String codename,
        CodenameGroup codenameGroup
) {
}
