package revisao1;

import java.util.Scanner;

public class RemoverElementoVetor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho do array (N): ");
			validarTamanho(n);

			int[] array = preencherArray(scanner, n);

			interagirRemocao(scanner, array);

			System.out.println("Programa encerrado.");
			System.out.println("Estado final do array: ");
			exibirArray(array);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void validarTamanho(int tamanho) {
		if (tamanho <= 0) {
			throw new IllegalArgumentException("O tamanho do array deve ser maior que zero.");
		}
	}

	private static int[] preencherArray(Scanner scanner, int tamanho) {
		int[] array = new int[tamanho];
		System.out.println("Digite os valores do array:");
		for (int i = 0; i < tamanho; i++) {
			array[i] = lerValorInteiro(scanner, String.format("Valor na posição %d: ", i));
		}
		return array;
	}

	private static void interagirRemocao(Scanner scanner, int[] array) {
		boolean continuar = true;
		while (continuar) {
			System.out.print("Deseja remover um elemento do array? (s/n): ");
			String resposta = scanner.next().toLowerCase();

			if (resposta.equals("s")) {
				int indice = lerValorInteiro(scanner, "Digite o índice do elemento a ser removido: ");

				if (indiceValido(indice, array.length)) {
					removerElemento(array, indice);
					System.out.println("Elemento removido com sucesso!");
					System.out.println("Array atualizado:");
					exibirArray(array);
				} else {
					System.out.println("Índice inválido! Tente novamente.");
				}
			} else if (resposta.equals("n")) {
				continuar = false;
			} else {
				System.out.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
			}
		}
	}

	private static boolean indiceValido(int indice, int tamanho) {
		return indice >= 0 && indice < tamanho;
	}

	private static void removerElemento(int[] array, int indice) {
		for (int i = indice; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = 0;
	}

	private static void exibirArray(int[] array) {
		for (int valor : array) {
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
