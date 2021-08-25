package br.com;

import br.com.pessoas.Pessoa;
import br.com.tarefas.ListaTarefas;
import br.com.tarefas.Tarefa;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Minhas Tarefas");
        System.out.println("------------------");

        ListaTarefas tarefas = new ListaTarefas();

        tarefas.adicionar("Estudar");
        tarefas.adicionar("Comer arroz e feijão");
        tarefas.adicionar("Malhar");


        tarefas.exibirTarefas();
        System.out.print("Tarefa buscada: ");
        Tarefa tarefaBuscada = tarefas.buscar("Estudar");
        tarefaBuscada.exibirTarefa();

        Pessoa pessoa1 = new Pessoa("Felipe", "Cardoso", "Lopes");
        System.out.println(pessoa1.getNomeCompleto());
    }
}
