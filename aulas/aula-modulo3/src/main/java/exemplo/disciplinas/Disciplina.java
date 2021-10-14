package exemplo.disciplinas;

import exemplo.alunos.Aluno;
import exemplo.exceptions.LimiteAlunosAlcancadoException;
import exemplo.professores.Professor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {
    private static final byte LIMITE = 10; // constante

    @Id
    private Long id;
    private String nome;
    private String descricao;

    @ManyToMany // 1 diciplina vários alunos / 1 aluno várias diciplinas
    @JoinTable(name="diciplina_aluno", joinColumns=
            {@JoinColumn(name="idDiciplina")}, inverseJoinColumns= // primeiro vem a coluna da classe onde estamos
            {@JoinColumn(name="idAluno")})
    private List<Aluno> alunos = new ArrayList<>();


    @ManyToOne
    // tabela diciplina deve possuir um professor
    @JoinColumn(name = "professor")
    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public void matricular(Aluno aluno) throws LimiteAlunosAlcancadoException {
        if (this.alunos.size() < LIMITE) {
            this.alunos.add(aluno);
        } else {
            throw new LimiteAlunosAlcancadoException("Limite de alunos alcançado " + LIMITE);
        }
    }

    public void mostrarAlunos() {
        // stream = object.values
        this.alunos.stream().forEach(aluno -> System.out.println(aluno.getNome()));
    }
}
