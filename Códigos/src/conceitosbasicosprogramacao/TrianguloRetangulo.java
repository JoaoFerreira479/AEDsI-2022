package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrianguloRetangulo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double catetoA = lerValorDouble(scanner, "Digite o valor do cateto a (em metros): ");
			double catetoB = lerValorDouble(scanner, "Digite o valor do cateto b (em metros): ");

			validarCatetos(catetoA, catetoB);

			double hipotenusa = calcularHipotenusa(catetoA, catetoB);
			double seno = calcularSeno(catetoB, hipotenusa);
			double cosseno = calcularCosseno(catetoA, hipotenusa);
			double tangente = calcularTangente(catetoB, catetoA);

			exibirResultados(hipotenusa, seno, cosseno, tangente);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static void validarCatetos(double catetoA, double catetoB) {
		if (catetoA <= 0 || catetoB <= 0) {
			throw new IllegalArgumentException("Os valores dos catetos devem ser positivos.");
		}
	}

	private static double calcularHipotenusa(double catetoA, double catetoB) {
		return Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
	}

	private static double calcularSeno(double catetoOposto, double hipotenusa) {
		return catetoOposto / hipotenusa;
	}

	private static double calcularCosseno(double catetoAdjacente, double hipotenusa) {
		return catetoAdjacente / hipotenusa;
	}

	private static double calcularTangente(double catetoOposto, double catetoAdjacente) {
		return catetoOposto / catetoAdjacente;
	}

	private static void exibirResultados(double hipotenusa, double seno, double cosseno, double tangente) {
		System.out.printf("a) O valor da hipotenusa (c): %.2f metros%n", hipotenusa);
		System.out.printf("b) O valor do seno de θ: %.4f%n", seno);
		System.out.printf("c) O valor do cosseno de θ: %.4f%n", cosseno);
		System.out.printf("d) O valor da tangente de θ: %.4f%n", tangente);
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
