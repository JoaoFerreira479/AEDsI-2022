package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversaoTempo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int minutos = lerValorInteiro(scanner, "Digite a quantidade de minutos: ");

			validarMinutos(minutos);

			String resultado = converterMinutosParaHorasMinutosSegundos(minutos);

			exibirResultado(resultado);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número inteiro.");
		} finally {
			scanner.close();
		}
	}

	private static void validarMinutos(int minutos) {
		if (minutos < 0) {
			throw new IllegalArgumentException("A quantidade de minutos não pode ser negativa.");
		}
	}

	private static String converterMinutosParaHorasMinutosSegundos(int totalMinutos) {
		int horas = totalMinutos / 60;
		int minutos = totalMinutos % 60;
		int segundos = 0;

		return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}

	private static void exibirResultado(String resultado) {
		System.out.printf("O tempo convertido é: %s%n", resultado);
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
