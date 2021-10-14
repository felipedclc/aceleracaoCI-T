package exemplo;

import exemplo.alunos.Aluno;
import exemplo.alunos.dao.AlunoDAO;
import exemplo.exceptions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {
    public static void main(String[] args) throws ValidationException, LimiteAlunosAlcancadoException {
        EntityManagerFactory factory = Persistence // acessar o banco e gerncia as entidades
                .createEntityManagerFactory("cursoCodenation");

        EntityManager manager = factory.createEntityManager();

        // Aluno DAO
        AlunoDAO alunoDAO = new AlunoDAO(manager);

        alunoDAO.save(new Aluno("login1", "191.000.000-00", "Teste Aluno"));
        alunoDAO.save(new Aluno("login2", "192.000.000-00", "Teste Aluno1"));
        Aluno aluno = new Aluno("login4", "194.000.000-00", "Aluno a remover");
        alunoDAO.save(aluno);

        alunoDAO.findAll().forEach(alunoEncontrado -> System.out.println(alunoEncontrado.getNome()));

        // alunoDAO.delete(aluno);

        // alunoDAO.findAll().forEach(alunoEncontrado -> System.out.println(alunoEncontrado.getNome()));

        factory.close();
    }
}
