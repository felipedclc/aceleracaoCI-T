package exemplo.alunos.dao;

import exemplo.alunos.Aluno;
import exemplo.disciplinas.Disciplina;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AlunoDAO { // DAO(Data Access Object) - onde ficam as lógicas de negócio

    // gerenciador de entidades do hibernate, como ele conseguimos fazer operações com o BD
    private EntityManager manager;

    public AlunoDAO(EntityManager manager) {
        this.manager = manager;
    }

    // @Transactional - apenas seria necessario utilizar o "manager.persist(aluno);"
    public void save(Aluno aluno) { // metodo insert/update
        manager.getTransaction().begin(); // inicia a transação
        manager.persist(aluno); // persistindo o aluno no BD
        manager.getTransaction().commit(); // abrindo a transação manualemnte(hibernate) e commitando
    }

    public void delete(Aluno aluno) {
        manager.getTransaction().begin();
        manager.remove(aluno);
        manager.getTransaction().commit();
    }

    public List<Aluno> findAll() {
        // criando a query manualmente em HQL(hibernate query language)
        return manager.createQuery("from Aluno").getResultList();
    }

    public List<Aluno> getAlunosPorDisciplina(Disciplina disciplina) {
        Query query = manager.createQuery("from aluno" +
                "INNER JOIN FETCH aluno.disciplinas as disciplina" +
                "where disciplina = ?1");
        query.setParameter(1, disciplina);
        return query.getResultList();
    }
}
