package exemplo.alunos;

import exemplo.exceptions.*;
import exemplo.usuario.Usuario;
import exemplo.disciplinas.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aluno extends Usuario {

    private Integer numeroMatricula;

    @ManyToMany
    @JoinTable(name="diciplina_aluno", joinColumns=
            {@JoinColumn(name="idAluno")}, inverseJoinColumns=
            {@JoinColumn(name="idDiciplina")})
    private List<Disciplina> diciplinas;

    public Aluno(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }
    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
