package usodeflag;

import java.util.Scanner;

public class GrupoDePessoas {

	private static final int ENCERRAR = -1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int quantidadeHomens = 0;
			int quantidadeMulheres = 0;
			int somaIdadesHomens = 0;
			int totalPessoas = 0;
			int maiorIdade = Integer.MIN_VALUE;
			int menorIdade = Integer.MAX_VALUE;

			exibirMensagem("Digite a idade e o gênero das pessoas:");
			exibirMensagem("Digite " + ENCERRAR + " para a idade para encerrar.");

			while (true) {
				int idade = lerValorInteiro(scanner, "Idade: ");

				if (idade == ENCERRAR) {
					break;
				}

				if (!validarIdade(idade)) {
					exibirMensagem(
							"Idade inválida! Digite uma idade maior ou igual a 0, ou " + ENCERRAR + " para encerrar.");
					continue;
				}

				maiorIdade = Math.max(maiorIdade, idade);
				menorIdade = Math.min(menorIdade, idade);

				char genero = lerGenero(scanner, "Gênero (M para masculino, F para feminino): ");

				if (genero == 'M') {
					quantidadeHomens++;
					somaIdadesHomens += idade;
				} else if (genero == 'F') {
					quantidadeMulheres++;
				}

				totalPessoas++;
			}

			exibirResultados(quantidadeHomens, quantidadeMulheres, somaIdadesHomens, totalPessoas, maiorIdade,
					menorIdade);

		} catch (Exception e) {
			exibirMensagemErro("Erro inesperado: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static boolean validarIdade(int idade) {
		return idade >= 0;
	}

	private static void exibirResultados(int quantidadeHomens, int quantidadeMulheres, int somaIdadesHomens,
			int totalPessoas, int maiorIdade, int menorIdade) {
		double mediaIdadeHomens = (quantidadeHomens > 0) ? (double) somaIdadesHomens / quantidadeHomens : 0;

		exibirMensagem("Resultados:");
		exibirMensagem("Número de homens: " + quantidadeHomens);
		exibirMensagem("Número de mulheres: " + quantidadeMulheres);
		exibirMensagem(String.format("Média de idades dos homens: %.2f", mediaIdadeHomens));

		if (totalPessoas > 0) {
			exibirMensagem("Maior idade verificada: " + maiorIdade);
			exibirMensagem("Menor idade verificada: " + menorIdade);
		} else {
			exibirMensagem("Nenhum dado foi inserido.");
		}
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (Exception e) {
				exibirMensagemErro("Entrada inválida. Por favor, digite um número inteiro válido.");
				scanner.nextLine(); // Limpa o buffer
			}
		}
	}

	private static char lerGenero(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				char genero = scanner.next().toUpperCase().charAt(0);
				if (genero == 'M' || genero == 'F') {
					return genero;
				} else {
					exibirMensagem("Gênero inválido! Digite M (masculino) ou F (feminino).\n");
				}
			} catch (Exception e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite M ou F.");
				scanner.nextLine(); // Limpa o buffer
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
