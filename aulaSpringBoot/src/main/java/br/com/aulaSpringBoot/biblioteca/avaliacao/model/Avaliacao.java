package br.com.aulaSpringBoot.biblioteca.avaliacao.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Avaliacao {

    @EmbeddedId // id da avaliação deve conter o id do leitor e o id do livro
    private AvaliacaoIdentity avaliacaoIdentity;

    @Max(5)
    @Min(1)
    @NotNull
    private byte nota;

    @NotNull
    @NotBlank
    private String avaliacao;

    public AvaliacaoIdentity getAvaliacaoIdentity() {
        return avaliacaoIdentity;
    }

    public void setAvaliacaoIdentity(AvaliacaoIdentity avaliacaoIdentity) {
        this.avaliacaoIdentity = avaliacaoIdentity;
    }

    public byte getNota() {
        return nota;
    }

    public void setNota(byte nota) {
        this.nota = nota;
    }
}
