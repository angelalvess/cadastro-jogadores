package com.angel.alves.cadastro_jogadores_desafio.web;

import com.angel.alves.cadastro_jogadores_desafio.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("listagem-jogadores")
public class ListPlayersController {

    private final PlayerService playerService;

    public ListPlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public String pageListPlayers(Model model) {
        var players = playerService.listPlayers();
        model.addAttribute("jogadores", players );
        return "listagem_jogadores";
    }

}
