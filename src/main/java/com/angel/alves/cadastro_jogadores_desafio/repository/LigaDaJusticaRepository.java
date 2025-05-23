package com.angel.alves.cadastro_jogadores_desafio.repository;

import com.angel.alves.cadastro_jogadores_desafio.model.CodenameGroup;
import com.angel.alves.cadastro_jogadores_desafio.web.CodenameDTO;
import com.angel.alves.cadastro_jogadores_desafio.web.LigaDaJusticaDTO;
import com.angel.alves.cadastro_jogadores_desafio.web.VingadoresDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

@Repository
public class LigaDaJusticaRepository implements CodenameRepository {

    @Override
    public CodenameDTO getCodenames() throws JsonProcessingException {

        var codenames = RestClient.builder()
                .baseUrl(CodenameGroup.LIGA_DA_JUSTICA.getUri()).build().get().retrieve().body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codenames, LigaDaJusticaDTO.class);


        return ligaDaJustica;
    }
}
