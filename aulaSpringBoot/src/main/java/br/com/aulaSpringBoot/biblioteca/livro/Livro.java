package br.com.aulaSpringBoot.biblioteca.livro;

import br.com.aulaSpringBoot.biblioteca.avaliacao.model.Avaliacao;
import br.com.aulaSpringBoot.biblioteca.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // valor incrementado aut
    private long id;

    @NotNull
    private String Titulo;

    @OneToMany // 1 livro possui varias avaliações
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    private List<Categoria> categorias;

    public Livro(String titulo) {
        Titulo = titulo;
    }
    public Livro() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
}
