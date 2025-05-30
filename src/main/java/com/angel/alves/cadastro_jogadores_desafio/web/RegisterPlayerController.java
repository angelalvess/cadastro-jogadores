package com.angel.alves.cadastro_jogadores_desafio.web;


import com.angel.alves.cadastro_jogadores_desafio.exception.UnavailableCodenameException;
import com.angel.alves.cadastro_jogadores_desafio.model.GrupoCodinome;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel.alves.cadastro_jogadores_desafio.model.Player;
import com.angel.alves.cadastro_jogadores_desafio.service.PlayerService;

@Controller
@RequestMapping("cadastro-jogador")
public class RegisterPlayerController {

    private final PlayerService playerService;

    public RegisterPlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public String pageRegisterPlayer(Model model) {
        return getViewAndModel(model, new Player(null, null, null, null, null));
    }


    @PostMapping
    public String registerPlayer(@ModelAttribute @Valid Player player, BindingResult result, Model model) throws JsonProcessingException {
        if (result.hasErrors())
            return getViewAndModel(model, player);

        try {
            playerService.registerPlayer(player);
            return "redirect:/listagem-jogadores";

        } catch (UnavailableCodenameException e) {
            result.rejectValue("grupoCodinome", "grupoCodinome", e.getMessage());
            return getViewAndModel(model, player);
        }

    }



    private String getViewAndModel(Model model, Player player) {
        model.addAttribute("player", player);
        model.addAttribute("gruposCodinomes", GrupoCodinome.values());
        return "cadastro_jogador"; // a view aqui
    }


}




