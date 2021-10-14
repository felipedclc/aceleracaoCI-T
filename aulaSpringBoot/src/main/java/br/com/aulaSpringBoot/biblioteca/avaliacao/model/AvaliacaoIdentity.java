package br.com.aulaSpringBoot.biblioteca.avaliacao.model;

import br.com.aulaSpringBoot.biblioteca.leitor.model.Leitor;
import br.com.aulaSpringBoot.biblioteca.livro.Livro;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable // informa que ela não é uma entidade, faz parte de outra entidade
public class AvaliacaoIdentity implements Serializable {

    @ManyToOne // 1 leitor faz várias avaliações
    @NotNull
    private Leitor leitor;

    @ManyToOne // 1 livro possui várias avaliações
    @NotNull
    private Livro livro;

    // generate equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoIdentity that = (AvaliacaoIdentity) o;
        return Objects.equals(leitor, that.leitor) && Objects.equals(livro, that.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leitor, livro);
    }
}
