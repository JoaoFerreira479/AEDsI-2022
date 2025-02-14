package revisao1;

import java.util.Scanner;

public class SegundoMaiorElemento {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho do vetor (N): ");
			validarTamanhoVetor(n);

			int[] vetor = preencherVetor(scanner, n);

			int segundoMaior = encontrarSegundoMaior(vetor);

			exibirResultado(segundoMaior);

		} catch (Exception e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void validarTamanhoVetor(int tamanho) {
		if (tamanho < 2) {
			throw new IllegalArgumentException("O vetor deve ter pelo menos 2 elementos.");
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

	private static int encontrarSegundoMaior(int[] vetor) {
		int maior = Integer.MIN_VALUE;
		int segundoMaior = Integer.MIN_VALUE;

		for (int valor : vetor) {
			if (valor > maior) {
				segundoMaior = maior;
				maior = valor;
			} else if (valor > segundoMaior && valor != maior) {
				segundoMaior = valor;
			}
		}

		if (segundoMaior == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Não foi possível encontrar um segundo maior elemento.");
		}

		return segundoMaior;
	}

	private static void exibirResultado(int segundoMaior) {
		System.out.printf("O segundo maior elemento do vetor é: %d%n", segundoMaior);
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
