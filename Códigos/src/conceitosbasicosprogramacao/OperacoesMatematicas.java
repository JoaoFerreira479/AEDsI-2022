package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperacoesMatematicas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int x = lerNumeroInteiro(scanner, "Digite o valor de X (positivo ou negativo): ");
			int y = lerNumeroInteiro(scanner, "Digite o valor de Y (positivo ou negativo): ");

			double raizQuadrada = calcularRaizQuadradaDosQuadrados(x, y);
			int restoDivisao = calcularRestoDivisao(x, y);
			double potencia = calcularPotencia(x, y);
			int soma = calcularSoma(x, y);
			int subtracao = calcularSubtracao(x, y);
			int multiplicacao = calcularMultiplicacao(x, y);
			double divisao = calcularDivisao(x, y);

			exibirResultados(raizQuadrada, restoDivisao, potencia, soma, subtracao, multiplicacao, divisao);

		} catch (ArithmeticException e) {
			exibirMensagemErro("Erro matemático: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro de entrada: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static double calcularRaizQuadradaDosQuadrados(int x, int y) {
		double somaDosQuadrados = Math.pow(x, 2) + Math.pow(y, 2);
		if (somaDosQuadrados < 0) {
			throw new ArithmeticException("Não é possível calcular a raiz quadrada de um número negativo.");
		}
		return Math.sqrt(somaDosQuadrados);
	}

	private static int calcularRestoDivisao(int x, int y) {
		if (y == 0) {
			throw new ArithmeticException("Divisão por zero não é permitida.");
		}
		return x % y;
	}

	private static double calcularPotencia(int x, int y) {
		if (x == 0 && y < 0) {
			throw new ArithmeticException("Não é possível calcular 0 elevado a um número negativo.");
		}
		return Math.pow(x, y);
	}

	private static int calcularSoma(int x, int y) {
		return x + y;
	}

	private static int calcularSubtracao(int x, int y) {
		return x - y;
	}

	private static int calcularMultiplicacao(int x, int y) {
		return x * y;
	}

	private static double calcularDivisao(int x, int y) {
		if (y == 0) {
			throw new ArithmeticException("Divisão por zero não é permitida.");
		}
		return (double) x / y;
	}

	private static void exibirResultados(double raizQuadrada, int restoDivisao, double potencia, int soma,
			int subtracao, int multiplicacao, double divisao) {
		System.out.printf("a) Raiz quadrada da soma dos quadrados: %.2f%n", raizQuadrada);
		System.out.printf("b) Resto da divisão de X por Y: %d%n", restoDivisao);
		System.out.printf("c) X elevado a Y: %.2f%n", potencia);
		System.out.printf("d) Soma de X e Y: %d%n", soma);
		System.out.printf("e) Subtração de X e Y: %d%n", subtracao);
		System.out.printf("f) Multiplicação de X por Y: %d%n", multiplicacao);
		System.out.printf("g) Divisão de X por Y: %.2f%n", divisao);
	}

	private static int lerNumeroInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
