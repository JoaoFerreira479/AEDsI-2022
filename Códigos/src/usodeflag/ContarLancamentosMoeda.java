package usodeflag;

import java.util.Scanner;

public class ContarLancamentosMoeda {

	private static final int CARA = 1;
	private static final int COROA = 2;
	private static final int ENCERRAR = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int contadorCara = 0;
			int contadorCoroa = 0;

			exibirMensagem("Digite os lançamentos da moeda:");
			exibirMensagem(CARA + " para Cara, " + COROA + " para Coroa, " + ENCERRAR + " para encerrar.");

			while (true) {
				int entrada = lerValorInteiro(scanner, "Lançamento: ");

				if (entrada == ENCERRAR) {
					break;
				}

				if (entrada == CARA) {
					contadorCara++;
				} else if (entrada == COROA) {
					contadorCoroa++;
				} else {
					exibirMensagem("Entrada inválida! Digite " + CARA + " (Cara), " + COROA + " (Coroa) ou " + ENCERRAR
							+ " para encerrar.");
				}
			}

			exibirResultados(contadorCara, contadorCoroa);

		} catch (Exception e) {
			exibirMensagemErro("Erro inesperado: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void exibirResultados(int contadorCara, int contadorCoroa) {
		exibirMensagem("Resultados dos lançamentos:");
		exibirMensagem("Cara: " + contadorCara + " ocorrência(s)");
		exibirMensagem("Coroa: " + contadorCoroa + " ocorrência(s)");
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (Exception e) {
				exibirMensagemErro("Entrada inválida. Por favor, digite um número inteiro válido.");
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
