package interfaces;

import interfaces.BasicoDAO;
import interfaces.FuncionarioDAO;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        // if (funcionarioDAO instanceof BasicoDAO)
            // funcionarioDAO.salvar(Funcionario001);
        // else
            // System.err.println("A Classe interfaces.FuncionarioDAO não implementa interfaces.BasicoDAO, nenhum procedimento foi realizado");

    }
}
