package exemplo;

import exemplo.alunos.Aluno;
import exemplo.disciplinas.Disciplina;
import exemplo.exceptions.LimiteAlunosAlcancadoException;
import exemplo.exceptions.ValidationException;
import exemplo.professores.Professor;
import exemplo.usuario.Usuario;
import exemplo.usuario.repositorios.RepositorioUsuario;

public class Main {
    public static void main(String[] args) {
        Professor professor = null;
        RepositorioUsuario repoUsuario = new RepositorioUsuario();
        try {
            professor = new Professor("art69", "107.665.781-74", "Arthur");
            Disciplina diciplina = new Disciplina("Matemática", professor);
            diciplina.matricular(new Aluno("felipedclc", "107.564.742-64", "Felipe"));
            // diciplina.mostrarAlunos();

            repoUsuario.add(professor);
            //                                      :: reference(executa o método - println)
            repoUsuario.findAll().forEach(System.out::println);
        }
        catch (ValidationException | LimiteAlunosAlcancadoException e) {
            System.out.println(e.getMessage());
        }


        // Aluno aluno1 = null;
        // try {
            // aluno1 = new Aluno("1", "102.336.587-74", "user");
        // } catch (ValidationException e) {
            // System.out.println("Message: " + e.getMessage());
            // e.printStackTrace(); // pilha de execução
        // }
        // System.out.println(aluno1);
    }
}
