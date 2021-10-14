package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public static long calcularSalarioLiquido(double salary) {
		if (salary < 1039.00) {
			return 0;
		}

		double liquidSalary = calculateDiscountINSS(salary);

		if (liquidSalary <= 3000)  {
			return Math.round(liquidSalary);
		}
		if (liquidSalary <= 6000) {
			return Math.round(liquidSalary * 0.925);
		}
		return Math.round(liquidSalary * 0.85);
	}

	private static double calculateDiscountINSS(double salary) {
		if (salary <= 1500) {
			return salary * 0.92;
		}
		if (salary <= 4000) {
			return salary * 0.91;
		}
		return salary * 0.89;
	}

	public static void main(String[] args) {
		System.out.printf("Result = %d", calcularSalarioLiquido(4000.01));
	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/