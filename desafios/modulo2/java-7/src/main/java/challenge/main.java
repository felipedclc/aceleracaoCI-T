package challenge;

public class main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Motorista motorista1 = new Motorista("Felipe", 30, 10, "455486");
        Motorista motorista2 = new Motorista("Maria", 55, 5, "455486");
        Carro carro1 = new Carro(motorista1, "HML6978", Cor.PRETO);
        Carro carro2 = new Carro(motorista2, "XYZ6978", Cor.BRANCO);

        for (int i = 1; i <= 10; i++) {
            estacionamento.estacionar(carro1);
        }
        estacionamento.estacionar(carro2);
    }
}
