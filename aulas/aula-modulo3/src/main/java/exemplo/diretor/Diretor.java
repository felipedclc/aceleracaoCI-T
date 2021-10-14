package exemplo.diretor;

import exemplo.exceptions.ValidationException;
import exemplo.relatorios.Coluna;
import exemplo.usuario.repositorios.UsuarioAutorizavel;

import java.util.Arrays;
import java.util.List;

public class Diretor extends UsuarioAutorizavel {

    private String dataCargo;

    public Diretor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    public boolean temAutorizacao() { // posso sobrescrever metodos da classe abstrata e criar metodos específicos
        return super.temAutorizacao();
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

    @Override
    protected List<String> getAutorizacoes() {
        return Arrays.asList("ADMIN");
    }

    @Coluna(posicao = 3, titulo = "Data do Cargo")
    public String getDataCargo() {
        return dataCargo;
    }

    public void setDataCargo(String dataCargo) {
        this.dataCargo = dataCargo;
    }
}
