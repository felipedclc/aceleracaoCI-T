package exemplo.relatorios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // annotation será nos métodos
@Retention(RetentionPolicy.RUNTIME) // uso em tempo de execução(diferente de tempo de copilação)
public @interface Coluna {
    int posicao(); // atributos
    String titulo();
}
