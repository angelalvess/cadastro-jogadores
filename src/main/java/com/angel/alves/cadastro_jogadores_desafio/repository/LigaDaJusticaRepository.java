package com.angel.alves.cadastro_jogadores_desafio.repository;

import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.angel.alves.cadastro_jogadores_desafio.web.CodenameDTO;
import com.angel.alves.cadastro_jogadores_desafio.web.LigaDaJusticaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Repository
public class LigaDaJusticaRepository implements CodenameRepository {

    @Override
    public CodenameDTO searchCodenames() throws JsonProcessingException {

        var codenames = RestClient.builder()
                .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri()).build().get().retrieve().body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codenames, LigaDaJusticaDTO.class);


        return ligaDaJustica;
    }
}
