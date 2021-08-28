package exemplo.professores;

import exemplo.exceptions.ValidationException;
import exemplo.usuario.Usuario;

public class Professor extends Usuario {
    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }
}
