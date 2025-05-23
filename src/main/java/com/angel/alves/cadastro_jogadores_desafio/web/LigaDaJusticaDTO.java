package com.angel.alves.cadastro_jogadores_desafio.web;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record LigaDaJusticaDTO(
        @JacksonXmlProperty Codenames codinomes
) implements CodenameDTO {

    @Override
    public List<String> getCodenames() {
        return codinomes.codinome;
    }

    record Codenames(
            @JacksonXmlElementWrapper(useWrapping = false)
                    @JacksonXmlProperty
            List<String> codinome){}
}
