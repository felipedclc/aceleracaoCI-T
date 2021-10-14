package br.com.aulaSpringBoot.biblioteca.categoria;

import br.com.aulaSpringBoot.biblioteca.livro.Livro;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @NotBlank
    // @Size
    private String nome;

    @ManyToMany
    private List<Livro> livros;
}
