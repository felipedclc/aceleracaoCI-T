package interfaces;

import interfaces.BasicoDAO;

import java.util.List;

public class FuncionarioDAO implements BasicoDAO {

    @Override
    public void salvar(Object bean) {

    }

    @Override
    public void atualizar(Object bean) {

    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    //Método a parte criado e implementado pelo próprio programador
    public void calcularSalario(){

    }
}