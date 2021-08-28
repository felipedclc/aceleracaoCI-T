package br.com.codenation.times;

import java.time.LocalDate;

public class Time {
    private Long idTime;
    private String nomeTime;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;

    public Time(Long idTime, String nomeTime, LocalDate dataCriacaoTime, String corUniformePrincipalTime, String corUniformeSecundarioTime) {
        setIdTime(idTime);
        setNomeTime(nomeTime);
        setDataCriacao(dataCriacao);
        setCorUniformePrincipal(corUniformePrincipal);
        setCorUniformeSecundario(corUniformeSecundario);
    }

    public Long getIdTime() { return idTime; }
    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNomeTime() { return nomeTime; }
    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() { return corUniformePrincipal; }
    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() { return corUniformeSecundario; }
    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    @Override
    public String toString() {
        return  nomeTime;
    }
}
