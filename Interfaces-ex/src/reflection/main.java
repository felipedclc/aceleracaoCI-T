package reflection;

public class main {
    public static void main(String[] args) {
        RefletirPessoa refletindo = new RefletirPessoa();
        System.out.println("Lista de métodos da classe refletida: \n");
        refletindo.listaNomeDosMetodos();
        System.out.println("lista de atributos: \n");
        refletindo.atributos();
        System.out.println("Invoca metodos da classe: \n");
        refletindo.invocaMetodos();
    }
}
