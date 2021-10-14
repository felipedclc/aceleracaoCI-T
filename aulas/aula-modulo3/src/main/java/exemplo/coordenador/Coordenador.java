package exemplo.coordenador;

import exemplo.exceptions.ValidationException;
import exemplo.usuario.repositorios.UsuarioAutorizavel;

import java.util.Arrays;
import java.util.List;

public class Coordenador extends UsuarioAutorizavel  /* implements UsuarioAutorizavel */ {

    private long matricula;

    public Coordenador(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public long getMatricula() { return matricula; }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return false;
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("COORD");
    }
}
