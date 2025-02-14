package estruturascondicionais;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TipoTriangulo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double lado1 = lerValorDouble(scanner, "Digite o valor do lado 1 do triângulo: ");
			double lado2 = lerValorDouble(scanner, "Digite o valor do lado 2 do triângulo: ");
			double lado3 = lerValorDouble(scanner, "Digite o valor do lado 3 do triângulo: ");

			validarTriangulo(lado1, lado2, lado3);

			String tipoTriangulo = identificarTipoTriangulo(lado1, lado2, lado3);

			exibirResultado(tipoTriangulo);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static void validarTriangulo(double lado1, double lado2, double lado3) {
		if (!(lado1 > 0 && lado2 > 0 && lado3 > 0)) {
			throw new IllegalArgumentException("Os lados devem ser maiores que zero.");
		}
		if (!(lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1)) {
			throw new IllegalArgumentException(
					"Os lados fornecidos não satisfazem a condição de desigualdade triangular.");
		}
	}

	private static String identificarTipoTriangulo(double lado1, double lado2, double lado3) {
		if (lado1 == lado2 && lado2 == lado3) {
			return "Equilátero (todos os lados iguais)";
		} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
			return "Isósceles (dois lados iguais)";
		} else {
			return "Escaleno (nenhum lado igual)";
		}
	}

	private static void exibirResultado(String tipoTriangulo) {
		System.out.printf("O triângulo é: %s%n", tipoTriangulo);
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
