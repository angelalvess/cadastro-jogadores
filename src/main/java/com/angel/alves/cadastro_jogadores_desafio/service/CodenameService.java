package com.angel.alves.cadastro_jogadores_desafio.service;


import com.angel.alves.cadastro_jogadores_desafio.exception.UnavailableCodenameException;
import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodenameService {

    private final CodenameRepositoryFactory codenameRepositoryFactory;

    public CodenameService(CodenameRepositoryFactory codenameRepositoryFactory) {
        this.codenameRepositoryFactory = codenameRepositoryFactory;
    }

    public String generateCodename(GrupoCodinome codenameGroup, List<String> codenamesInUse) throws JsonProcessingException {
        var availableCodenames = codenamesAvailable(codenameGroup, codenamesInUse);

        if (availableCodenames.isEmpty())
            throw new UnavailableCodenameException("There are no codenames available for " + codenameGroup.getName());

        return drawCodename(availableCodenames);
    }

    public List<String> codenamesAvailable(GrupoCodinome codenameGroup, List<String> codenamesInUse) throws JsonProcessingException {
        var codenames = allCodenames(codenameGroup);
        return codenames.stream().filter(codename-> !codenamesInUse.contains(codename)).toList();
    }



    public List<String> allCodenames(GrupoCodinome codenameGroup  ) throws JsonProcessingException {
        var codenames = codenameRepositoryFactory.create(codenameGroup);
        return codenames.searchCodenames().getCodenames();
    }



    private String drawCodename(List<String> codenames){
        return codenames.get((int) (Math.random() * codenames.size()));
    }

}
