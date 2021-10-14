package br.com.aulaSpringBoot.biblioteca.leitor.model;

import br.com.aulaSpringBoot.biblioteca.avaliacao.model.Avaliacao;
import br.com.aulaSpringBoot.biblioteca.livro.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @NotBlank
    private String name;

    @OneToMany // 1 leitor faz várias avaliações
    List<Avaliacao> avaliacoes;

    public Leitor(String name) {
        this.name = name;
    }
    public Leitor() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
