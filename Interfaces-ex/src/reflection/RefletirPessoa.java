package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefletirPessoa {
    public void listaNomeDosMetodos() {
        try {
            Class cl = Class.forName("reflection.Pessoa");
            Method[] metodos = cl.getDeclaredMethods();

            for (int i = 0; i < metodos.length; i++) {
                System.out.println(metodos[i].toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  void atributos() {
        try {
            Class cl = Class.forName("reflection.Pessoa");
            Method[] metodos = cl.getDeclaredMethods();

            for (int i = 0; i < metodos.length; i++) {
                Method m = metodos[i];
                System.out.println("Nomes do metodo " + m.getName());
                System.out.println("Tipo de retorno " + m.getReturnType());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void invocaMetodos() {
        Pessoa pessoa = new Pessoa("Felipe Cardoso", 32, "CPF da pessoa", "RG da pessoa");

        try {
            Class cl = Class.forName("reflection.Pessoa");
            Field[] fel = cl.getDeclaredFields();
            Method[] met = cl.getDeclaredMethods();

            for (int i = 0; i < met.length; i++) {
                System.out.println(fel[i].getName() + " : " + met[i].invoke(pessoa));
            }
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
