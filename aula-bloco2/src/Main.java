import alunos.Aluno;
import alunos.ValidationException;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = null;
        try {
            aluno1 = new Aluno("1", "102.336.587-74", "user");
        } catch (ValidationException e) {
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace(); // pilha de execução
        }
        System.out.println(aluno1);
    }
}
