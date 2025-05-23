package com.angel.alves.cadastro_jogadores_desafio.service;


import com.angel.alves.cadastro_jogadores_desafio.model.CodenameGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodenameService {


    public String generateCodename(CodenameGroup  codenameGroup, List<String> codenamesInUse){
        // 1 - listar disponiveis
        // 2 - regra codinomes indisponeis
        // 3 - sortear um

        return "aa";
    }

    public List<String> CodenamesAvailable(CodenameGroup  codenameGroup, List<String> codenamesInUse){}
        // pegar todos codinomes de um grupo a partir do metodo abaixo
        // filtrar todos codinomes com os codinomes em uso deixando so os disponveis
        // retornar disponveis
    public List<String> allCodenames(CodenameGroup  codenameGroup){
        // pegar todos codinomes de um determinado grupo
    }


}
