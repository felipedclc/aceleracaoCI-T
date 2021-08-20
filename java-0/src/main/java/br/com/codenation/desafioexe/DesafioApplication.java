package br.com.codenation.desafioexe;

import br.com.codenation.desafioexe.fibonacci.Fibonacci;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		Fibonacci fibonacci = new Fibonacci();
		return fibonacci.fiboList(350);
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}