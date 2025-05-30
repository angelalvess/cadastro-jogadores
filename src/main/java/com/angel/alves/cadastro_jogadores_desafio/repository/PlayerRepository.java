package com.angel.alves.cadastro_jogadores_desafio.repository;


import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.angel.alves.cadastro_jogadores_desafio.model.Player;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {

    private final JdbcClient jdbcClient;

    public PlayerRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Player save(Player player) {
        jdbcClient.sql("""
                         INSERT INTO JOGADORES (name, email, telephone, codinome, grupo_codinome)
                         VALUES (:name, :email, :telephone, :codinome, :grupoCodinome)
                        """)
                .param("name", player.name())
                .param("email", player.email())
                .param("telephone", player.telephone())
                .param("codinome", player.codinome())
                .param("grupoCodinome", player.grupoCodinome().name())
                .update();
        return player;
    }


    public List<String> listCodenamesInUse(GrupoCodinome grupoCodinome) {
        return jdbcClient.sql("SELECT distinct(codinome) FROM JOGADORES WHERE grupo_codinome = :grupoCodinome")
                .param("grupoCodinome", grupoCodinome.name())
                .query(String.class)
                .list();
    }

    public List<Player> listPlayers() {
        return jdbcClient.sql("SELECT * FROM JOGADORES ORDER BY LOWER(name), id")
                .query(Player.class)
                .list();
    }

}

