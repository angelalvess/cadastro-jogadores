package com.angel.alves.cadastro_jogadores_desafio.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Player(
        @NotBlank String name,
        @NotBlank @Email String email,
        String telephone,
        String codinome,
        @NotNull GrupoCodinome grupoCodinome
) {

    public Player withCodinome(String codinome) {
        return new Player(name, email, telephone, codinome, grupoCodinome);
    }
}
