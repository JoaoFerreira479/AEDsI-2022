package revisao1;

import java.util.HashMap;
import java.util.Scanner;

public class ContarDuplicados {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho do vetor: ");
			validarTamanhoVetor(n);

			int[] vetor = preencherVetor(scanner, n);

			int numDuplicados = contarDuplicados(vetor);

			exibirResultado(numDuplicados);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void validarTamanhoVetor(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("O vetor deve ter pelo menos 1 elemento.");
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

	private static int contarDuplicados(int[] vetor) {
		HashMap<Integer, Integer> frequencia = new HashMap<>();
		int contadorDuplicados = 0;

		for (int elemento : vetor) {
			frequencia.put(elemento, frequencia.getOrDefault(elemento, 0) + 1);
		}

		for (int valor : frequencia.values()) {
			if (valor > 1) {
				contadorDuplicados++;
			}
		}

		return contadorDuplicados;
	}

	private static void exibirResultado(int numDuplicados) {
		System.out.printf("O número de elementos duplicados no vetor é: %d%n", numDuplicados);
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
