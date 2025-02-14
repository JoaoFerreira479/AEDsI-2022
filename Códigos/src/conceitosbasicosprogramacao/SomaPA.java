package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SomaPA {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int a1 = lerValorInteiro(scanner, "Digite o valor do primeiro termo da PA (a1): ");
			int r = lerValorInteiro(scanner, "Digite o valor da razão da PA (r): ");
			int n = lerValorInteiro(scanner, "Digite o número de termos (n): ");

			validarNumeroDeTermos(n);

			int soma = calcularSomaPA(a1, r, n);

			exibirResultado(a1, r, n, soma);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static void validarNumeroDeTermos(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("O número de termos (n) deve ser maior que zero.");
		}
	}

	private static int calcularSomaPA(int a1, int r, int n) {
		return (n * ((2 * a1) + ((n - 1) * r))) / 2;
	}

	private static void exibirResultado(int a1, int r, int n, int soma) {
		System.out.printf("A soma dos primeiros %d termos da PA com a1 = %d e razão = %d é: %d%n", n, a1, r, soma);
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
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
