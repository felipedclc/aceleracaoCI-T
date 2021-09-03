package exemplo.usuario.repositorios;

import exemplo.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario { // simulando um DB de usuários
         // List (interface/ tipo)       Arraylist(implementação)
    private final List<Usuario> usuarios = new ArrayList<>(); // final = constante

    public void add(Usuario user) { this.usuarios.add(user); }

    public void delete(Usuario user) { usuarios.remove(user); }

    public Usuario search(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) { return usuario; }
        }
        return null;
    }

    public List<Usuario> findAll() { return usuarios; }
}
