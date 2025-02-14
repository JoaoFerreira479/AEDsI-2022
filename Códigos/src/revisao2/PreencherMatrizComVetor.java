package revisao2;

import java.util.Scanner;

public class PreencherMatrizComVetor {

	private static final int TAMANHO_VETOR = 5;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int[] vetor = new int[TAMANHO_VETOR];
			System.out.println("Preenchendo o vetor de " + TAMANHO_VETOR + " posições:");
			preencherVetor(scanner, vetor);

			System.out.println("Vetor preenchido:");
			exibirVetor(vetor);

			int[][] matriz = preencherMatrizComVetor(vetor);

			System.out.println("Matriz resultante:");
			exibirMatriz(matriz);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void preencherVetor(Scanner scanner, int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = lerValorInteiro(scanner, String.format("Digite o valor na posição %d: ", i));
		}
	}

	private static int[][] preencherMatrizComVetor(int[] vetor) {
		int[][] matriz = new int[3][vetor.length];

		preencherLinhaMultiplicacao(vetor, matriz[0], 2);

		preencherLinhaSoma(vetor, matriz[1], 3);

		preencherLinhaRestoDivisao(matriz[0], matriz[1], matriz[2]);

		return matriz;
	}

	private static void preencherLinhaMultiplicacao(int[] vetor, int[] linha, int multiplicador) {
		for (int i = 0; i < vetor.length; i++) {
			linha[i] = vetor[i] * multiplicador;
		}
	}

	private static void preencherLinhaSoma(int[] vetor, int[] linha, int soma) {
		for (int i = 0; i < vetor.length; i++) {
			linha[i] = vetor[i] + soma;
		}
	}

	private static void preencherLinhaRestoDivisao(int[] linha1, int[] linha2, int[] linhaResultado) {
		for (int i = 0; i < linha1.length; i++) {
			linhaResultado[i] = (linha2[i] != 0) ? linha1[i] % linha2[i] : 0;
		}
	}

	private static void exibirVetor(int[] vetor) {
		for (int valor : vetor) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}

	private static void exibirMatriz(int[][] matriz) {
		for (int[] linha : matriz) {
			for (int valor : linha) {
				System.out.print(valor + "\t");
			}
			System.out.println();
		}
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
