package estruturasrepeticao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiplos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int x = lerValorInteiro(scanner, "Digite o valor de X (o número base para os múltiplos): ");
			int y = lerValorInteiro(scanner, "Digite o valor de Y (o limite superior): ");

			validarValores(x, y);

			String multiplos = calcularMultiplos(x, y);

			exibirMultiplos(x, y, multiplos);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static void validarValores(int x, int y) {
		if (x <= 0 || y <= 0) {
			throw new IllegalArgumentException("Os valores de X e Y devem ser inteiros positivos.");
		}
	}

	private static String calcularMultiplos(int x, int y) {
		StringBuilder multiplos = new StringBuilder();
		for (int i = 1; i <= y; i++) {
			if (i % x == 0) {
				multiplos.append(i).append(" ");
			}
		}
		return multiplos.toString().trim();
	}

	private static void exibirMultiplos(int x, int y, String multiplos) {
		System.out.printf("Múltiplos de %d de 1 até %d:%n%s%n", x, y, multiplos);
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				int valor = scanner.nextInt();
				if (valor <= 0) {
					throw new IllegalArgumentException("O valor deve ser um número inteiro positivo.");
				}
				return valor;
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
