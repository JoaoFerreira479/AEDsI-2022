package revisao1;

import java.util.Scanner;

public class PosicoesParesRecursivo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho do vetor (N): ");
			validarTamanhoVetor(n);

			int[] vetor = preencherVetor(scanner, n);

			System.out.println("Vetor completo:");
			exibirVetor(vetor);

			System.out.println("Elementos nas posições pares do vetor:");
			imprimirPosicoesPares(vetor, 0);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void validarTamanhoVetor(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("O tamanho do vetor deve ser maior que zero.");
		}
	}

	private static int[] preencherVetor(Scanner scanner, int tamanho) {
		int[] vetor = new int[tamanho];
		System.out.println("Digite os valores do vetor:");
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = lerValorInteiro(scanner, String.format("Valor na posição %d: ", i));
		}
		return vetor;
	}

	private static void imprimirPosicoesPares(int[] vetor, int indice) {
		if (indice >= vetor.length) {
			return;
		}

		if (indice % 2 == 0) {
			System.out.printf("Posição %d: %d%n", indice, vetor[indice]);
		}

		imprimirPosicoesPares(vetor, indice + 1);
	}

	private static void exibirVetor(int[] vetor) {
		for (int valor : vetor) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (Exception e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
