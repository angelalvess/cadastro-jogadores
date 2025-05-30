package com.angel.alves.cadastro_jogadores_desafio.repository;

import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.angel.alves.cadastro_jogadores_desafio.web.CodenameDTO;
import com.angel.alves.cadastro_jogadores_desafio.web.VingadoresDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
public class VingadoresRepository implements CodenameRepository {


    @Override
    public CodenameDTO searchCodenames() throws JsonProcessingException {

        var codenames = RestClient.builder().defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(GrupoCodinome.VINGADORES.getUri()).build().get().retrieve().body(String.class);

        var objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codenames, VingadoresDTO.class);


        return vingadores;
    }
}
