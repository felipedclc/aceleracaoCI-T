package pessoa_heranca;

import java.util.Date;

public class main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Felipe", "107.330.206-98", new Date());
        System.out.println("Veja como os atributos foram preenchidos\n\nNome: " + aluno1.nome);
        System.out.println("CPF: " + aluno1.cpf);
        System.out.println("Data nascimento: " + aluno1.data_nascimento.toString());
    }
}
