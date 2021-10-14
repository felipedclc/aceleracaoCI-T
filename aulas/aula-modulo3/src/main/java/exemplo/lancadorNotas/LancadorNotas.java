package exemplo.lancadorNotas;

import exemplo.usuario.repositorios.UsuarioAutorizavel;

public class LancadorNotas {

    public void login(UsuarioAutorizavel usuarioAutorizavel) {
        boolean hasAuth = usuarioAutorizavel.temAutorizacao();
        if (hasAuth) {
            System.out.println("Usuário tem autorização");
        } else {
            System.out.println("Não possui autorização");
        }
    }
}
