package br.com.aulaSpringBoot.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // escaneia todos os pacotes acima em busca das annotations
public class BibliotecaApplication { // deve ficar no pacote raiz

	public static void main(String[] args) { // valor default
		SpringApplication.run(BibliotecaApplication.class, args);
	}
	
}
