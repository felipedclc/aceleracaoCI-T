package exemplo.exceptions;

public class LimiteAlunosAlcancadoException extends Exception {
    // // gerando construtor que recebe a string message
    public LimiteAlunosAlcancadoException(String message) {
        super(message);
    }
}
