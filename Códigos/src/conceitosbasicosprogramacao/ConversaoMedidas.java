package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversaoMedidas {

	private static final int FATOR_DECIMETROS = 10;
	private static final int FATOR_CENTIMETROS = 100;
	private static final int FATOR_MILIMETROS = 1000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double metros = lerValorDouble(scanner, "Digite o valor em metros: ");

			validarMedida(metros);

			double decimetros = converterMedida(metros, FATOR_DECIMETROS);
			double centimetros = converterMedida(metros, FATOR_CENTIMETROS);
			double milimetros = converterMedida(metros, FATOR_MILIMETROS);

			exibirResultados(decimetros, centimetros, milimetros);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número decimal válido.");
		} finally {
			scanner.close();
		}
	}

	private static void validarMedida(double metros) {
		if (metros < 0) {
			throw new IllegalArgumentException("A medida em metros não pode ser negativa.");
		}
	}

	private static double converterMedida(double metros, int fator) {
		return metros * fator;
	}

	private static void exibirResultados(double decimetros, double centimetros, double milimetros) {
		System.out.printf("Valor em decímetros: %.1f dm%n", decimetros);
		System.out.printf("Valor em centímetros: %.1f cm%n", centimetros);
		System.out.printf("Valor em milímetros: %.1f mm%n", milimetros);
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
