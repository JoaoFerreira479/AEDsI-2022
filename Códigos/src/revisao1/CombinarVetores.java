package revisao1;

import java.util.Scanner;

public class CombinarVetores {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho dos vetores (N): ");
			validarTamanho(n);

			int[] vetor1 = preencherVetor(scanner, n, "primeiro");
			int[] vetor2 = preencherVetor(scanner, n, "segundo");

			int[] vetorCombinado = combinarVetores(vetor1, vetor2);

			System.out.println("Vetor combinado:");
			exibirVetor(vetorCombinado);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void validarTamanho(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("O tamanho dos vetores deve ser maior que zero.");
		}
	}

	private static int[] preencherVetor(Scanner scanner, int tamanho, String nomeVetor) {
		int[] vetor = new int[tamanho];
		System.out.printf("Digite os valores do %s vetor:%n", nomeVetor);
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = lerValorInteiro(scanner, String.format("Valor na posição %d: ", i));
		}
		return vetor;
	}

	private static int[] combinarVetores(int[] vetor1, int[] vetor2) {
		int[] combinado = new int[vetor1.length + vetor2.length];
		System.arraycopy(vetor1, 0, combinado, 0, vetor1.length);
		System.arraycopy(vetor2, 0, combinado, vetor1.length, vetor2.length);
		return combinado;
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
