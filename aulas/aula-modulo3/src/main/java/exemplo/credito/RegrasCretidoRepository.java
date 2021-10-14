package exemplo.credito;

import java.util.ArrayList;
import java.util.List;

public class RegrasCretidoRepository { // simulando bd

    public List<RegraCredito> findAllRegras() {
        List<RegraCredito> regras = new ArrayList<>();

        RegraCredito regra1 = new RegraCredito();
        regra1.setNome("ScoreSerasa");
        regra1.setReferencia("ScoreSerasa");
        regra1.setValorReferencia(500);
        regra1.setRegra(RegraCredito.RegraValor.MIN);

        RegraCredito regra2 = new RegraCredito();
        regra2.setNome("ValorDivida");
        regra2.setReferencia("ValorDivida");
        regra2.setValorReferencia(1000);
        regra2.setRegra(RegraCredito.RegraValor.MAX);

        regras.add(regra1);
        regras.add(regra2);

        return regras;
    }
}
