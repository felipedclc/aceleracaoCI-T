package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.jogadores.Jogador;
import br.com.codenation.times.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	public final List<Time> times = new ArrayList<>();
	public final List<Jogador> jogadores = new ArrayList<>();

	// try {}
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (buscarTimePorId(id) != null) throw new IdentificadorUtilizadoException();

		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		times.add(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (buscarJogadorPorId(id) != null) throw new IdentificadorUtilizadoException();
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();

		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		jogadores.add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		if (buscarJogadorPorId(idJogador) == null) throw new JogadorNaoEncontradoException();

		jogadores.forEach(jogador -> jogador.setCapitao(false));
		
		for (Jogador jogador : jogadores) {
			if (idJogador.equals(jogador.getIdJogador())) jogador.setCapitao(true);
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();

		for (Jogador jogador : jogadores) {
			if (jogador.getTimeId().equals(idTime) && jogador.getCapitao()) {
				return jogador.getIdJogador();
			};
		}
		throw new CapitaoNaoInformadoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		if (buscarJogadorPorId(idJogador) == null) throw new JogadorNaoEncontradoException();

		String nomeJogador = null;
		for (Jogador jogador : jogadores) {
			if (jogador.getIdJogador().equals(idJogador)) {
				nomeJogador = jogador.getNomeJogador();
			}
		}
		return nomeJogador;
	}

	public String buscarNomeTime(Long idTime) {
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();
		String nomeTime = null;
		for (Time time : times)
			if (time.getIdTime().equals(idTime)) {
				nomeTime = time.getNomeTime();
			}

		return nomeTime;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();

		List<Long> jogadores = new ArrayList<>();
		Time time = buscarTimePorId(idTime);
		for (Jogador jogador : this.jogadores) {
			if (time.getIdTime().equals(jogador.getTimeId())) {
				jogadores.add(jogador.getIdJogador());
			}
		}
		return jogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();

		Long bestHabilityPlayer = 0L;
		Integer bestHability = 0;
		for (Jogador jogador : jogadores) {
			if (jogador.getTimeId().equals(idTime)) {
				if (jogador.getNivelHabilidade() > bestHability) {
					bestHability = jogador.getNivelHabilidade();
					bestHabilityPlayer = jogador.getIdJogador();
				}
			}
		}
		return bestHabilityPlayer;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();

		LocalDate date = LocalDate.now();
		Long idOldPlayer = 0L;
		for (Jogador jogador : jogadores) {
			if (jogador.getTimeId().equals(idTime)) {
				if (jogador.getDataNascimento().isBefore(date)) {
					date = jogador.getDataNascimento();
					idOldPlayer = jogador.getIdJogador();
				}
			}
		}
		return idOldPlayer;
	}

	public List<Long> buscarTimes() {
		List<Long> times = new ArrayList<>();
		this.times.forEach(time -> times.add(time.getIdTime()));
		return times;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (buscarTimePorId(idTime) == null) throw new TimeNaoEncontradoException();

		BigDecimal biggestSalary = BigDecimal.valueOf(0);
		Long playerId = 0L;
		for (Jogador jogador : jogadores) {
			if (jogador.getTimeId().equals(idTime)) {
				if (jogador.getSalario().compareTo(biggestSalary) > 0) {
					biggestSalary = jogador.getSalario();
					playerId = jogador.getIdJogador();
				}
			}
		}
		return playerId;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (buscarJogadorPorId(idJogador) == null) throw new JogadorNaoEncontradoException();

		BigDecimal salary = BigDecimal.valueOf(0);
		for (Jogador jogador : jogadores)
			if (jogador.getIdJogador().equals(idJogador)) salary = jogador.getSalario();

		return salary;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		if (jogadores.size() == 0) return topJogadores;

		List<Jogador> setPlayerlist = jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade)
				.reversed().thenComparing(Jogador::getIdJogador))
				.collect(Collectors.toList());

		for(int i = 0; i <top; i++) {
			topJogadores.add(setPlayerlist.get(i).getIdJogador());
		}

		return topJogadores;
	}

	public Time buscarTimePorId(Long id) {
		for (Time time : times) {
			if (time.getIdTime().equals(id)) return time;
		}
		return null;
	}

	public Jogador buscarJogadorPorId(Long id) {
		for (Jogador jogador : jogadores) {
			if (jogador.getIdJogador().equals(id)) return jogador;
		}
		return null;
	}

}
