package exemplo.credito;

import exemplo.credito.externo.Pessoa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalizadorCredito {

    private RegrasCretidoRepository repository;

    public AnalizadorCredito() { this.repository = new RegrasCretidoRepository(); }

    public boolean analisarCredito(Pessoa pessoa) {
        // obtendo o objeto Class e pegando todos seus métodos (getMethods) - deixa publica a classe privada
        Method[] methods = Pessoa.class.getDeclaredMethods(); // pega só os métodos declarados na classe
        boolean result = true;
        for(RegraCredito regra : this.repository.findAllRegras()) {
            for (Method method : methods) {
                // selecionando o metodo correto
                if (method.getName().toUpperCase().contains("GET" + regra.getReferencia().toUpperCase())) {
                    try {
                        long valor = (long) method.invoke(pessoa); // chamando(invocando) o metodo
                        result = validaRegra(valor, regra);
                        if (!result) return false;
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return result;
    }

    private boolean validaRegra(long valor, RegraCredito regra) {
        if (regra.getRegra().equals(RegraCredito.RegraValor.MAX)) { // se for o valor máximo
            return valor <= regra.getValorReferencia();
        }
        return valor >= regra.getValorReferencia(); // RegraCredito.RegraValor.MIN
    }
}
