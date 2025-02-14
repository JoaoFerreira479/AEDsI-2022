package estruturascondicionais;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PagamentoProduto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double valorProduto = lerValorDouble(scanner, "Digite o valor do produto: R$ ");

			exibirMenu();

			int opcao = lerOpcao(scanner, "Selecione uma opção de pagamento (1 a 4): ");

			processarPagamento(opcao, valorProduto, scanner);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar valores numéricos.");
		} finally {
			scanner.close();
		}
	}

	private static void processarPagamento(int opcao, double valorProduto, Scanner scanner) {
		switch (opcao) {
		case 1 -> calcularAVistaComDesconto(valorProduto);
		case 2 -> calcularAVistaSemDesconto(valorProduto);
		case 3 -> calcularParcelamentoSemJuros(valorProduto, scanner);
		case 4 -> calcularParcelamentoComJuros(valorProduto, scanner);
		default -> exibirMensagemErro("Opção inválida. Escolha uma opção entre 1 e 4.");
		}
	}

	private static void exibirMenu() {
		System.out.println("Opções de pagamento:");
		System.out.println("1 - Pagamento à vista no dinheiro ou PIX com 10% de desconto");
		System.out.println("2 - Pagamento à vista no cartão sem desconto");
		System.out.println("3 - Pagamento em até 3x sem juros");
		System.out.println("4 - Pagamento em até 10x com juros de 15%");
	}

	private static void calcularAVistaComDesconto(double valorProduto) {
		double valorFinal = valorProduto * 0.90;
		System.out.printf("Pagamento à vista (dinheiro/PIX). Valor final: R$ %.2f%n", valorFinal);
	}

	private static void calcularAVistaSemDesconto(double valorProduto) {
		System.out.printf("Pagamento à vista (cartão). Valor final: R$ %.2f%n", valorProduto);
	}

	private static void calcularParcelamentoSemJuros(double valorProduto, Scanner scanner) {
		int parcelas = lerNumeroParcelas(scanner, "Digite o número de parcelas (até 3): ", 3);
		double valorParcela = valorProduto / parcelas;
		System.out.printf("Pagamento em %d parcelas sem juros. Valor de cada parcela: R$ %.2f%n", parcelas,
				valorParcela);
	}

	private static void calcularParcelamentoComJuros(double valorProduto, Scanner scanner) {
		double valorFinal = valorProduto * 1.15;
		int parcelas = lerNumeroParcelas(scanner, "Digite o número de parcelas (até 10): ", 10);
		double valorParcela = valorFinal / parcelas;
		System.out.printf(
				"Pagamento em %d parcelas com 15%% de juros. Valor final: R$ %.2f. Valor de cada parcela: R$ %.2f%n",
				parcelas, valorFinal, valorParcela);
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				double valor = scanner.nextDouble();
				if (valor <= 0) {
					throw new IllegalArgumentException("O valor do produto deve ser maior que zero.");
				}
				return valor;
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static int lerOpcao(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				int opcao = scanner.nextInt();
				if (opcao < 1 || opcao > 4) {
					throw new IllegalArgumentException("Opção inválida. Escolha uma opção entre 1 e 4.");
				}
				return opcao;
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static int lerNumeroParcelas(Scanner scanner, String mensagem, int maxParcelas) {
		while (true) {
			try {
				System.out.print(mensagem);
				int parcelas = scanner.nextInt();
				if (parcelas < 1 || parcelas > maxParcelas) {
					throw new IllegalArgumentException(
							"Número de parcelas inválido. Escolha entre 1 e " + maxParcelas + ".");
				}
				return parcelas;
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}