package com.angel.alves.cadastro_jogadores_desafio.repository;


import com.angel.alves.cadastro_jogadores_desafio.model.Player;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository {

    private final JdbcClient jdbcClient;

    public PlayerRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Player save(Player player) {
        jdbcClient.sql("""
                         INSERT INTO JOGADORES (name, email, telephone, codinome, grupo_codinome)
                         VALUES (:name, :email, :telephone, :codename, :codenameGroup)
                        """)
                .param("name", player.name())
                .param("email", player.email())
                .param("telephone", player.telephone())
                .param("codename()", player.codename())
                .param("codenameGroup", player.codenameGroup().name())
                .update();
        return player;
    }

}

