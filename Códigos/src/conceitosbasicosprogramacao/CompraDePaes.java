package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompraDePaes {

	private static final int CONVERSAO_CENTAVOS = 100;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double dinheiroDisponivel = lerValorDouble(scanner,
					"Digite a quantidade de dinheiro que você tem (em reais): ");
			int precoPaoCentavos = lerValorInteiro(scanner, "Digite o preço de cada pão (em centavos): ");

			validarValores(dinheiroDisponivel, precoPaoCentavos);

			int quantidadePaes = calcularQuantidadePaes(dinheiroDisponivel, precoPaoCentavos);
			double troco = calcularTroco(dinheiroDisponivel, precoPaoCentavos);

			exibirResultados(quantidadePaes, troco);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static void validarValores(double dinheiro, int precoPaoCentavos) {
		if (dinheiro < 0) {
			throw new IllegalArgumentException("O valor de dinheiro não pode ser negativo.");
		}
		if (precoPaoCentavos <= 0) {
			throw new IllegalArgumentException("O preço do pão deve ser maior que zero.");
		}
	}

	private static int calcularQuantidadePaes(double dinheiro, int precoPaoCentavos) {
		int dinheiroCentavos = (int) Math.round(dinheiro * CONVERSAO_CENTAVOS);
		return dinheiroCentavos / precoPaoCentavos;
	}

	private static double calcularTroco(double dinheiro, int precoPaoCentavos) {
		int dinheiroCentavos = (int) Math.round(dinheiro * CONVERSAO_CENTAVOS);
		int trocoCentavos = dinheiroCentavos % precoPaoCentavos;
		return trocoCentavos / (double) CONVERSAO_CENTAVOS;
	}

	private static void exibirResultados(int quantidadePaes, double troco) {
		System.out.printf("Você pode comprar %d pão(ães).%n", quantidadePaes);
		System.out.printf("Seu troco será de R$ %.2f.%n", troco);
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

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Entrada inválida. Por favor, digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
