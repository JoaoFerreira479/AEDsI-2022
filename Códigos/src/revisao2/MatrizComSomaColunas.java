package revisao2;

import java.util.Scanner;

public class MatrizComSomaColunas {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			final int LINHAS = 4;
			final int COLUNAS = 4;

			int[][] matriz = new int[LINHAS][COLUNAS];

			System.out.println("Preenchendo a matriz (as 3 primeiras linhas):");
			preencherMatriz(scanner, matriz, LINHAS - 1, COLUNAS);

			calcularSomaColunas(matriz);

			System.out.println("Matriz final com a soma das colunas na última linha:");
			exibirMatriz(matriz);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void preencherMatriz(Scanner scanner, int[][] matriz, int linhas, int colunas) {
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = lerValorInteiro(scanner, String.format("Digite o valor na posição [%d][%d]: ", i, j));
			}
		}
	}

	private static void calcularSomaColunas(int[][] matriz) {
		for (int j = 0; j < matriz[0].length; j++) {
			int soma = 0;
			for (int i = 0; i < matriz.length - 1; i++) {
				soma += matriz[i][j];
			}
			matriz[matriz.length - 1][j] = soma;
		}
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
