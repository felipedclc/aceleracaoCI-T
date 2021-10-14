package classesAbstract;

public class main {
    public static void main(String[] args) {
        Programador objProgramador = new Programador();
        Designer objDesigner = new Designer();

        objProgramador.Salario = 1300.00;
        System.out.println("Calculando Reajuste Programador\n");
        objProgramador.Reajustar();
        System.out.println("Novo salário: " + objProgramador.Salario);

        objDesigner.Salario = 1100.00;
        System.out.println("\nCalculando Reajuste Designer\n");
        objDesigner.Reajustar();
        System.out.println("Novo salário: " + objDesigner.Salario);
    }
}
