package com.angel.alves.cadastro_jogadores_desafio.service;

import com.angel.alves.cadastro_jogadores_desafio.model.Player;
import com.angel.alves.cadastro_jogadores_desafio.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CodenameService codenameService;


    public PlayerService(PlayerRepository playerRepository, CodenameService codenameService) {
        this.playerRepository = playerRepository;
        this.codenameService = codenameService;
    }

    public Player registerPlayer(Player player) throws JsonProcessingException {
        var codenamesInUse = playerRepository.listCodenamesInUse(player.codenameGroup());
        var newCodename = codenameService.generateCodename(player.codenameGroup(), codenamesInUse);
        return playerRepository.save(new Player(player.name(), player.email(),player.telephone(),newCodename,player.codenameGroup()));
    }

    public List<Player> listPlayers() {
        return playerRepository.listPlayers();
    }


}
