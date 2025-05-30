package com.angel.alves.cadastro_jogadores_desafio.service;

import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.angel.alves.cadastro_jogadores_desafio.model.Player;
import com.angel.alves.cadastro_jogadores_desafio.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CodenameService codenameService;


    public PlayerService(PlayerRepository playerRepository, CodenameService codenameService) {
        this.playerRepository = playerRepository;
        this.codenameService = codenameService;
    }

    @Transactional
    public Player registerPlayer(Player player) throws JsonProcessingException {
        var codenamesInUse = listCodenamesInUse(player.grupoCodinome());
        var newCodename = codenameService.generateCodename(player.grupoCodinome(), codenamesInUse);
        var newPlayer = player.withCodinome(newCodename);
        return playerRepository.save(newPlayer);
    }

    public List<Player> listPlayers() {
        return playerRepository.listPlayers();
    }

    private List<String> listCodenamesInUse(GrupoCodinome grupoCodinome) {
        var codenamesInUse = playerRepository.listCodenamesInUse(grupoCodinome);

        return codenamesInUse;
    }

}
