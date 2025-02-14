package revisao1;

import java.util.Arrays;
import java.util.Scanner;

public class TerceiroMenorElemento {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int linhas = lerValorInteiro(scanner, "Digite o número de linhas da matriz: ");
			int colunas = lerValorInteiro(scanner, "Digite o número de colunas da matriz: ");

			validarDimensoesMatriz(linhas, colunas);

			int[][] matriz = preencherMatriz(scanner, linhas, colunas);

			int terceiroMenor = encontrarTerceiroMenor(matriz);

			exibirResultado(terceiroMenor);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void validarDimensoesMatriz(int linhas, int colunas) {
		if (linhas * colunas < 3) {
			throw new IllegalArgumentException("A matriz deve ter pelo menos 3 elementos.");
		}
	}

	private static int[][] preencherMatriz(Scanner scanner, int linhas, int colunas) {
		int[][] matriz = new int[linhas][colunas];
		System.out.println("Digite os valores da matriz:");
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = lerValorInteiro(scanner, String.format("Valor na posição [%d][%d]: ", i, j));
			}
		}
		return matriz;
	}

	private static int encontrarTerceiroMenor(int[][] matriz) {
		int totalElementos = matriz.length * matriz[0].length;
		int[] vetor = transformarMatrizEmVetor(matriz, totalElementos);

		Arrays.sort(vetor);

		return vetor[2];
	}

	private static int[] transformarMatrizEmVetor(int[][] matriz, int totalElementos) {
		int[] vetor = new int[totalElementos];
		int k = 0;

		for (int[] linha : matriz) {
			for (int elemento : linha) {
				vetor[k++] = elemento;
			}
		}
		return vetor;
	}

	private static void exibirResultado(int terceiroMenor) {
		System.out.printf("O terceiro menor elemento da matriz é: %d%n", terceiroMenor);
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
