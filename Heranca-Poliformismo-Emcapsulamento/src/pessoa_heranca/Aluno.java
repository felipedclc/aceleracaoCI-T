package pessoa_heranca;

import java.util.Date;

// classe aluno possui os atributos da classe pessoa mais o atributo matricula
public class Aluno extends Pessoa {

    public Aluno(String _nome, String _cpf, Date _data) {
        super(_nome, _cpf, _data);
    }
    public String matricula;

    @Override
    public double tirarCopias(int qtd) { //Preço para tirar copias para alunos
        return 0.07 * (double) qtd;
    }
}
