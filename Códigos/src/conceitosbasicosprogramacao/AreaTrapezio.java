package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AreaTrapezio {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double baseMaior = lerValorDouble(scanner, "Digite o valor da base maior do trapézio (em metros): ");
			double baseMenor = lerValorDouble(scanner, "Digite o valor da base menor do trapézio (em metros): ");
			double altura = lerValorDouble(scanner, "Digite o valor da altura do trapézio (em metros): ");

			validarValores(baseMaior, baseMenor, altura);

			double area = calcularAreaTrapezio(baseMaior, baseMenor, altura);

			exibirResultado(area);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static void validarValores(double baseMaior, double baseMenor, double altura) {
		if (baseMaior <= 0 || baseMenor <= 0 || altura <= 0) {
			throw new IllegalArgumentException("Os valores da base maior, base menor e altura devem ser positivos.");
		}
	}

	private static double calcularAreaTrapezio(double baseMaior, double baseMenor, double altura) {
		return ((baseMaior + baseMenor) * altura) / 2;
	}

	private static void exibirResultado(double area) {
		System.out.printf("A área do trapézio é: %.2f metros quadrados.%n", area);
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Entrada inválida. Por favor, digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
