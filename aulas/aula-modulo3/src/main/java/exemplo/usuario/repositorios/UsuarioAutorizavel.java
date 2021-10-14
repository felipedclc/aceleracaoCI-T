package exemplo.usuario.repositorios;

import exemplo.exceptions.ValidationException;
import exemplo.usuario.Usuario;

import java.util.List;

public abstract class UsuarioAutorizavel extends Usuario {
    public UsuarioAutorizavel(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public boolean temAutorizacao() {
        List<String> autorizacoes = getAutorizacoes(); // lista vem desse metodo
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();
    }

    protected abstract boolean verificarAutorizacaoLogin();

    protected abstract List<String> getAutorizacoes(); // deve ser implementado nas classes filhas
}
