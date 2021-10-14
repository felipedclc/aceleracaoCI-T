package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    List<Carro> parkedCars= new ArrayList<>();
    Integer numeroVagas = 10;

    public void estacionar(Carro carro) {
        if (carrosEstacionados() < numeroVagas) parkedCars.add(carro);
        else {
            for (int i = 1; i < numeroVagas; i++) {
                if (parkedCars.get(i).getMotorista().getIdade() < 55) {
                    System.out.println(parkedCars.get(i).getPlaca() + ", carro numero: " + i);
                    parkedCars.remove(1);
                    parkedCars.add(carro);
                } else {
                    throw new EstacionamentoException("Estacionamento atingiu o limite de pessoas sêniors");
                }
            }
        }
    }

    public int carrosEstacionados() { return parkedCars.size(); }

    public boolean carroEstacionado(Carro carro) {
        for (Carro parkedCar : parkedCars) {
            if (parkedCar.getPlaca().equals(carro.getPlaca())) return true;
        }
        return false;
    }
}
