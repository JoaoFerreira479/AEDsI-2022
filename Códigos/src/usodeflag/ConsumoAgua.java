package usodeflag;

import java.util.Scanner;

public class ConsumoAgua {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double somaConsumos = 0.0;
			int quantidadeConsumidores = 0;
			double maiorConsumo = 0.0;
			double menorConsumo = Double.MAX_VALUE;

			exibirMensagem("Digite o consumo de água em m³ das residências.\nDigite um valor negativo para encerrar.");

			while (true) {
				double consumo = lerValorDouble(scanner, "Consumo de água (m³): ");

				if (consumo < 0) {
					break;
				}

				somaConsumos += consumo;
				quantidadeConsumidores++;
				maiorConsumo = Math.max(maiorConsumo, consumo);
				menorConsumo = Math.min(menorConsumo, consumo);
			}

			exibirResultados(somaConsumos, quantidadeConsumidores, maiorConsumo, menorConsumo);

		} catch (Exception e) {
			exibirMensagemErro("Erro inesperado: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void exibirResultados(double somaConsumos, int quantidade, double maior, double menor) {
		exibirMensagem("Resultados:");
		if (quantidade > 0) {
			double media = somaConsumos / quantidade;
			exibirMensagem(String.format("Média de consumo: %.2f m³", media));
			exibirMensagem("Número de consumidores analisados: " + quantidade);
			exibirMensagem(String.format("Maior consumo: %.2f m³", maior));
			exibirMensagem(String.format("Menor consumo: %.2f m³", menor));
		} else {
			exibirMensagem("Nenhum consumidor foi analisado.");
		}
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
