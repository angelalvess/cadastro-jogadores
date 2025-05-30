package com.angel.alves.cadastro_jogadores_desafio.service;


import com.angel.alves.cadastro_jogadores_desafio.exception.UnknownGroupCodenameException;
import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.angel.alves.cadastro_jogadores_desafio.repository.CodenameRepository;
import com.angel.alves.cadastro_jogadores_desafio.repository.LigaDaJusticaRepository;
import com.angel.alves.cadastro_jogadores_desafio.repository.VingadoresRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CodenameRepositoryFactory {

    private final VingadoresRepository vingadoresRepository;
    private final LigaDaJusticaRepository ligaDaJusticaRepository;

    public CodenameRepositoryFactory(VingadoresRepository vingadoresRepository, LigaDaJusticaRepository ligaDaJusticaRepository) {
        this.vingadoresRepository = vingadoresRepository;
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
    }

    public CodenameRepository create(GrupoCodinome grupoCodinome){
        return switch (grupoCodinome){
            case VINGADORES -> vingadoresRepository;
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
        };
    }

}
