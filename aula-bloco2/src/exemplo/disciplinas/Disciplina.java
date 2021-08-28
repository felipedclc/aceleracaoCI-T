package exemplo.disciplinas;

import exemplo.alunos.Aluno;
import exemplo.exceptions.LimiteAlunosAlcancadoException;
import exemplo.professores.Professor;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private static final byte LIMITE = 10; // constante

    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
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
