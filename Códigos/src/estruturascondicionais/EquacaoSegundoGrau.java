package estruturascondicionais;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EquacaoSegundoGrau {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double a = lerValorDouble(scanner, "Digite o valor de a (coeficiente do termo x²): ");
			double b = lerValorDouble(scanner, "Digite o valor de b (coeficiente do termo x): ");
			double c = lerValorDouble(scanner, "Digite o valor de c (termo constante): ");

			validarCoeficienteA(a);

			double delta = calcularDelta(a, b, c);

			determinarRaizes(a, b, delta);

		} catch (IllegalArgumentException e) {
			exibirMensagemErro("Erro: " + e.getMessage());
		} catch (InputMismatchException e) {
			exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números válidos.");
		} finally {
			scanner.close();
		}
	}

	private static void validarCoeficienteA(double a) {
		if (a == 0) {
			throw new IllegalArgumentException("Equação inválida. O coeficiente 'a' deve ser diferente de zero.");
		}
	}

	private static double calcularDelta(double a, double b, double c) {
		return Math.pow(b, 2) - (4 * a * c);
	}

	private static void determinarRaizes(double a, double b, double delta) {
		if (delta < 0) {
			System.out.println("A equação não possui raízes reais.");
		} else if (delta == 0) {
			double raiz = -b / (2 * a);
			System.out.printf("A equação possui uma raiz real: %.2f%n", raiz);
		} else {
			double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
			double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.printf("A equação possui duas raízes reais: %.2f e %.2f%n", raiz1, raiz2);
		}
	}

	private static double lerValorDouble(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static void exibirMensagemErro(String mensagem) {
		System.err.println(mensagem);
	}
}
