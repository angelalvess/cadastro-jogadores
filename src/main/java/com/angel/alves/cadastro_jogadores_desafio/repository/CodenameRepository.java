package com.angel.alves.cadastro_jogadores_desafio.repository;

import com.angel.alves.cadastro_jogadores_desafio.web.CodenameDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodenameRepository {
    CodenameDTO getCodenames() throws JsonProcessingException;
}
