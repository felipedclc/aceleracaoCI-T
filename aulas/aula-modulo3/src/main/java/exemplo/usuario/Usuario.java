package exemplo.usuario;

import com.sun.istack.internal.NotNull;
import exemplo.exceptions.*;
import exemplo.relatorios.*;

import javax.persistence.*;

@Entity // tabela usuario
// @Table(name = ) - caso precise alterar o nome da tabela no BD
@Inheritance(strategy = InheritanceType.JOINED) // estratégia de mapeamento para as heranças
public class Usuario {

    @Id
    private Long id;
    @Column(nullable = false)
    private String login;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    public Usuario(String login, String cpf, String nome) throws ValidationException {
        setLogin(login);
        setCpf(cpf);
        setNome(nome);
    }

    public String getLogin() { return login; }
    public void setLogin(String login) throws ValidationException {
        if(validateLogin(login)) {
            this.login = login;
        } else {
            throw new ValidationException("Login inválido");
        }
    }

    @Coluna(posicao = 2, titulo = "CPF")
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) throws ValidationException {
        if (validateCpf(cpf)) {
            this.cpf = cpf;
        } else {
            throw new ValidationException("CPF inválido");
        }
    }

    @Coluna(posicao = 1, titulo = "NOME")
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    private boolean validateLogin(String login) {
        return login != null && login.length() > 3 && login.length() < 20;
    }

    private boolean validateCpf(String cpf) {
        return cpf != null && !cpf.isEmpty() && (cpf.length() == 11 || cpf.length() == 14);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", login " + login;
    }
}
