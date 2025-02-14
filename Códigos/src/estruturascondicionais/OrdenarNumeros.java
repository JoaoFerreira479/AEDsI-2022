package estruturascondicionais;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrdenarNumeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int num1 = lerValorInteiro(scanner, "Digite o primeiro número inteiro: ");
			int num2 = lerValorInteiro(scanner, "Digite o segundo número inteiro: ");
			int num3 = lerValorInteiro(scanner, "Digite o terceiro número inteiro: ");

			int[] numerosOrdenados = ordenarNumeros(num1, num2, num3);

			exibirResultado(numerosOrdenados);

		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static int[] ordenarNumeros(int num1, int num2, int num3) {
		int[] numeros = { num1, num2, num3 };
		Arrays.sort(numeros);
		return numeros;
	}

	private static void exibirResultado(int[] numerosOrdenados) {
		System.out.printf("Os números em ordem crescente são: %d, %d, %d%n", numerosOrdenados[0], numerosOrdenados[1],
				numerosOrdenados[2]);
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
