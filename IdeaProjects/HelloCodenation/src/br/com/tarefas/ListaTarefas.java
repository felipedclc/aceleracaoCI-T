package br.com.tarefas;

import java.util.ArrayList;

public class ListaTarefas {
    ArrayList<Tarefa> tarefas = new ArrayList<>(); // não precisa de declarar o tamanho

    public void adicionar(Tarefa tarefa) {
        if (tarefa != null && tarefa.obterTamanhoTarefa() <= 20) {
            this.tarefas.add(tarefa);
        } else {
            System.out.println("A tarefa é invaĺida");
        }

    }

    public void adicionar(String descricao) { // sobrecarga do metodo adicionar
        Tarefa tarefa = new Tarefa(descricao); // criando uma nova tarefa
        adicionar(tarefa);
    }

    public void remover(int posicao) {
        if (posicao > this.tarefas.size()) {
            System.out.println("Tarefa não existe");
        } else {
            this.tarefas.remove(posicao);
        }
    }

    public void remover(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    public Tarefa buscar(String descricao) {
        for (Tarefa tarefa: tarefas) { // para cada tarefa na lista(tarefas)
            if (descricao.equals(tarefa.descricao)) { // equals: compara a referências da classe
                return tarefa; // termina o for
            }
        }
        System.out.println("Tarefa não encontrada");
        return null;
    }

    public void exibirTarefas() {
        for(Tarefa tarefa: tarefas) {
            tarefa.exibirTarefa();
        }
    }
}
