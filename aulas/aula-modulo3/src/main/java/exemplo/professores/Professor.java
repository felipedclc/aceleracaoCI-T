package exemplo.professores;

import exemplo.disciplinas.Disciplina;
import exemplo.exceptions.ValidationException;
import exemplo.usuario.repositorios.UsuarioAutorizavel;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Professor extends UsuarioAutorizavel /* implements UsuarioAutorizavel */ {

    @OneToMany(mappedBy = "professor") // um professor tem (varias) / uma lista de diciplinas
    private List<Disciplina> disciplinas;

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    public boolean temAutorizacao() {
        return true;
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("PROF");
    }
}
