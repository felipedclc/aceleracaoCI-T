package br.com.codenation.jogadores;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
    private Long idJogador;
    private Long timeId;
    private String nomeJogador;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private Boolean capitao;

    public Jogador(Long idJogador, Long timeId, String nomeJogador, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        setIdJogador(idJogador);
        setTimeId(timeId);
        setNomeJogador(nomeJogador);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
        this.capitao = false;
    }

    public Long getIdJogador() { return idJogador; }
    public void setIdJogador(Long idJogador) {
        this.idJogador = idJogador;
    }

    public Long getTimeId() { return timeId; }
    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public String getNomeJogador() { return nomeJogador; }
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() { return nivelHabilidade; }
    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Boolean getCapitao() { return capitao; }
    public void setCapitao(Boolean isCapitain) {
        this.capitao = isCapitain;
    }

    @Override
    public String toString() {
        return  nomeJogador;
    }
}
