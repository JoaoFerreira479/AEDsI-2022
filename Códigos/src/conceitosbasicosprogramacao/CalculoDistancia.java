package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculoDistancia {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double distanciaAB = lerValorDouble(scanner, "Digite a distância do segmento AB (em metros): ");
			double distanciaBC = lerValorDouble(scanner, "Digite a distância do segmento BC (em metros): ");

			validarDistancias(distanciaAB, distanciaBC);

			double distanciaAC = calcularHipotenusa(distanciaAB, distanciaBC);

			exibirResultado(distanciaAC);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static void validarDistancias(double distanciaAB, double distanciaBC) {
		if (distanciaAB < 0 || distanciaBC < 0) {
			throw new IllegalArgumentException("As distâncias não podem ser negativas.");
		}
	}

	private static double calcularHipotenusa(double cateto1, double cateto2) {
		return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
	}

	private static void exibirResultado(double distanciaAC) {
		System.out.printf("A distância do ponto A ao ponto C é: %.2f metros.%n", distanciaAC);
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Entrada inválida. Por favor, digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
