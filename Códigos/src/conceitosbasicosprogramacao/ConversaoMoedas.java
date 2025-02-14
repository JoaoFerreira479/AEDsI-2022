package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversaoMoedas {

	private static final double TAXA_EURO = 5.21;
	private static final double TAXA_DOLAR = 4.74;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double valorReais = lerValorDouble(scanner, "Digite o valor em reais (R$): ");

			validarValor(valorReais);

			double valorEmEuros = converterMoeda(valorReais, TAXA_EURO);
			double valorEmDolares = converterMoeda(valorReais, TAXA_DOLAR);

			exibirResultados(valorEmEuros, valorEmDolares);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número decimal válido.");
		} finally {
			scanner.close();
		}
	}

	private static void validarValor(double valorReais) {
		if (valorReais < 0) {
			throw new IllegalArgumentException("O valor em reais não pode ser negativo.");
		}
	}

	private static double converterMoeda(double valorReais, double taxa) {
		return valorReais / taxa;
	}

	private static void exibirResultados(double valorEmEuros, double valorEmDolares) {
		System.out.printf("O valor em euros é: € %.2f%n", valorEmEuros);
		System.out.printf("O valor em dólares é: $ %.2f%n", valorEmDolares);
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
