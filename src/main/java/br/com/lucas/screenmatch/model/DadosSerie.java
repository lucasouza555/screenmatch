package br.com.lucas.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*precisa usar essa anotação porque se não o Jackson vai tentar mapear todas  as propriedades do JSON
  com os atributos da classe e como não temos todas as propriedades do JSON mapeadas como atributo da
  classe pedimos para ele ignorar a propriedades que não tiverem um atributo da classe mapeado*/

/*Resumindo: ignora as propriedades do JSON que não possuem um atributo da classe relacionado.*/
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titutlo,
                         @JsonAlias("totalSeasons")  Integer totalTemporadas,
                         /*lê a propriedade "imdbRating" do JSON mas na hora de escrever no JSON cria a propriedade "avaliacao"*/
                         @JsonAlias("imdbRating")
                         String avaliacao,
                         /*lê e escreve o JSON com a propridade sendo "imdbVotes"*/
                         @JsonProperty("imdbVotes")
                         String votos) {
}
