package exemplo;

import exemplo.credito.*;
import exemplo.credito.externo.*;
import exemplo.diretor.*;
import exemplo.exceptions.*;
import exemplo.lancadorNotas.*;
import exemplo.professores.*;
import exemplo.usuario.repositorios.*;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main_reflection {

    public static void main(String[] args) throws ValidationException, NoSuchFieldException, IllegalAccessException {

        // Arrays.stream(Pessoa.class.getMethods()).forEach(System.out::println);
        // Arrays.stream(Pessoa.class.getMethods()).forEach(method -> System.out.println(method.getName()));
        Arrays.stream(Pessoa.class.getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));



        Pessoa pessoa = getPessoa();
        AnalizadorCredito analizador = new AnalizadorCredito();
        // boolean resultado = analizador.;

        Field nome = Pessoa.class.getDeclaredField("nome");
        nome.setAccessible(true); // permite alterar classes privadas
        nome.set(pessoa, "novo nome");

        System.out.print("Analise de credito: ");
        // if (!resultado) System.out.println("Credito reprovado");
        // else System.out.println("Credito aprovado");

        // UsuarioAutorizavel usuario = new Diretor("professorLogin", "123.456.789-10", "João");
        // new LancadorNotas().login(usuario);

    }

    private static Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Felipe");
        pessoa.setCpf("108.334.586-67");
        pessoa.setQtdChequesDevolvidos(0);
        pessoa.setScoreSCPC(500);
        pessoa.setScoreSerasa(500);
        pessoa.setValorDivida(1001);
        return pessoa;
    }


    // public static void verificarAutorizacao(UsuarioAutorizavel usuario) {
        // if (usuario.temAutorizacao()) {
            // System.out.println("Tem autorização");
        // };
    // }
}