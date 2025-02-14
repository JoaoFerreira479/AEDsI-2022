package revisao2;

import java.util.Scanner;

public class OperacoesVetores {

	private static final int TAMANHO_VETOR = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int[] vetorX = new int[TAMANHO_VETOR];
			int[] vetorY = new int[TAMANHO_VETOR];

			System.out.println("Preenchendo o vetor X:");
			preencherVetor(scanner, vetorX);

			System.out.println("Preenchendo o vetor Y:");
			preencherVetor(scanner, vetorY);

			System.out.println("Resultado da soma dos vetores:");
			exibirVetor(somarVetores(vetorX, vetorY));

			System.out.println("Resultado do produto dos vetores:");
			exibirVetor(multiplicarVetores(vetorX, vetorY));

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

	private static int[] somarVetores(int[] vetorX, int[] vetorY) {
		int[] soma = new int[vetorX.length];
		for (int i = 0; i < vetorX.length; i++) {
			soma[i] = vetorX[i] + vetorY[i];
		}
		return soma;
	}

	private static int[] multiplicarVetores(int[] vetorX, int[] vetorY) {
		int[] produto = new int[vetorX.length];
		for (int i = 0; i < vetorX.length; i++) {
			produto[i] = vetorX[i] * vetorY[i];
		}
		return produto;
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
