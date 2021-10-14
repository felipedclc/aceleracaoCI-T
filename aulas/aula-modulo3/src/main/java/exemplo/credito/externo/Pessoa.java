package exemplo.credito.externo;

public class Pessoa {
    private String cpf;
    private String nome;
    private long scoreSerasa;
    private long scoreSCPC;
    private long qtdChequesDevolvidos;
    private long valorDivida;

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getScoreSerasa() { return scoreSerasa; }
    public void setScoreSerasa(long scoreSerasa) {
        this.scoreSerasa = scoreSerasa;
    }

    public long getScoreSCPC() { return scoreSCPC; }
    public void setScoreSCPC(long scoreSCPC) {
        this.scoreSCPC = scoreSCPC;
    }

    public long getQtdChequesDevolvidos() { return qtdChequesDevolvidos; }
    public void setQtdChequesDevolvidos(long qtdChequesDevolvidos) {
        this.qtdChequesDevolvidos = qtdChequesDevolvidos;
    }

    public long getValorDivida() { return valorDivida; }
    public void setValorDivida(long valorDivida) {
        this.valorDivida = valorDivida;
    }
}
