package com.angel.alves.cadastro_jogadores_desafio.service;


import com.angel.alves.cadastro_jogadores_desafio.exception.UnknownGroupCodenameException;
import com.angel.alves.cadastro_jogadores_desafio.model.CodenameGroup;
import com.angel.alves.cadastro_jogadores_desafio.repository.CodenameRepository;
import com.angel.alves.cadastro_jogadores_desafio.repository.LigaDaJusticaRepository;
import com.angel.alves.cadastro_jogadores_desafio.repository.VingadoresRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CodenameRepositoryFactory {

    private final VingadoresRepository vingadoresRepository;
    private final LigaDaJusticaRepository ligaDaJusticaRepository;

    public CodenameRepositoryFactory(VingadoresRepository vingadoresRepository, LigaDaJusticaRepository ligaDaJusticaRepository) {
        this.vingadoresRepository = vingadoresRepository;
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
    }

    public CodenameRepository create(CodenameGroup codenameGroup){
        return switch (codenameGroup){
            case VINGADORES -> vingadoresRepository;
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            default -> throw new UnknownGroupCodenameException("Grupo de codinome desconhecido: " + codenameGroup);
        };
    }

}
