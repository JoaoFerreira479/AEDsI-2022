package estruturascondicionais;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MediaAproveitamento {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double nota1 = lerNota(scanner, "Digite a nota da prova 1 (0 a 100): ");
			double nota2 = lerNota(scanner, "Digite a nota da prova 2 (0 a 100): ");
			double nota3 = lerNota(scanner, "Digite a nota da prova 3 (0 a 100): ");
			double nota4 = lerNota(scanner, "Digite a nota da prova 4 (0 a 100): ");

			double mediaAproveitamento = calcularMediaAproveitamento(nota1, nota2, nota3, nota4);

			String conceito = determinarConceito(mediaAproveitamento);
			String status = determinarStatus(conceito);

			exibirResultados(mediaAproveitamento, conceito, status);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static double calcularMediaAproveitamento(double nota1, double nota2, double nota3, double nota4) {
		return (nota1 + nota2 * 2 + nota3 + nota4 * 3) / 7.0;
	}

	private static String determinarConceito(double mediaAproveitamento) {
		if (mediaAproveitamento >= 90) {
			return "A";
		} else if (mediaAproveitamento >= 75) {
			return "B";
		} else if (mediaAproveitamento >= 60) {
			return "C";
		} else if (mediaAproveitamento >= 40) {
			return "D";
		} else {
			return "E";
		}
	}

	private static String determinarStatus(String conceito) {
		if (conceito.equals("A") || conceito.equals("B") || conceito.equals("C")) {
			return "Aprovado";
		} else {
			return "Reprovado";
		}
	}

	private static void exibirResultados(double mediaAproveitamento, String conceito, String status) {
		System.out.printf("Média de Aproveitamento (MA): %.2f%n", mediaAproveitamento);
		System.out.printf("Conceito: %s%n", conceito);
		System.out.printf("Status: %s%n", status);
	}

	private static double lerNota(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				double nota = scanner.nextDouble();
				validarNota(nota);
				return nota;
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número decimal válido.");
				scanner.nextLine();
			} catch (IllegalArgumentException e) {
				exibirMensagemErro("Erro: " + e.getMessage());
			}
		}
	}

	private static void validarNota(double nota) {
		if (nota < 0 || nota > 100) {
			throw new IllegalArgumentException("A nota deve estar entre 0 e 100.");
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
