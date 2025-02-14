package usodeflag;

import java.util.Scanner;

public class SerieDeNumeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double somaNumeros = 0.0;
			int quantidadeNumeros = 0;
			double maiorNumero = Double.MIN_VALUE;
			double menorNumero = Double.MAX_VALUE;

			exibirMensagem("Digite uma série de números.");
			exibirMensagem("Digite um número negativo para encerrar.");

			while (true) {
				double numero = lerValorDouble(scanner, "Número: ");

				if (numero < 0) {
					break;
				}

				somaNumeros += numero;
				quantidadeNumeros++;
				maiorNumero = Math.max(maiorNumero, numero);
				menorNumero = Math.min(menorNumero, numero);
			}

			exibirResultados(somaNumeros, quantidadeNumeros, maiorNumero, menorNumero);

		} catch (Exception e) {
			exibirMensagemErro("Erro inesperado: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void exibirResultados(double somaNumeros, int quantidadeNumeros, double maiorNumero,
			double menorNumero) {
		double media = (quantidadeNumeros > 0) ? somaNumeros / quantidadeNumeros : 0;

		exibirMensagem("Resultados:");
		exibirMensagem(String.format("Média verificada: %.2f", media));
		exibirMensagem("Maior número lido: " + (quantidadeNumeros > 0 ? maiorNumero : "Nenhum número foi inserido"));
		exibirMensagem("Menor número lido: " + (quantidadeNumeros > 0 ? menorNumero : "Nenhum número foi inserido"));
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (Exception e) {
				exibirMensagemErro("Entrada inválida. Por favor, digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
