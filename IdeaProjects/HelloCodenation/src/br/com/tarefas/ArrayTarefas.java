package br.com.tarefas;

public class ArrayTarefas {
    Tarefa[] tarefas; // criando um array de tarefas
    int acc = 0;

    public ArrayTarefas(int tamanho) {
        this.tarefas = new Tarefa[tamanho]; // declarando o tamanho do array
    }

    public void adicionar(Tarefa tarefa) {
        tarefas[acc] = tarefa;
        acc++;
    }

    public void removerTarefa(int posicao) {
        tarefas[posicao] = null;
    }

    public void exibirTarefas() {
        for(Tarefa tarefa: tarefas) { // executa uma vez para cada item(tarefas)
            tarefa.exibirTarefa();
        }
    }
}
