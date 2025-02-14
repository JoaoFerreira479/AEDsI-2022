package estruturasrepeticao;

import java.util.Random;

public class NumerosAleatorios {

	public static void main(String[] args) {
		Random gerador = new Random();

		System.out.println("Gerando 10 números aleatórios e classificando como PAR ou ÍMPAR:");

		for (int i = 0; i < 10; i++) {
			int num = gerarNumeroAleatorio(gerador);
			String classificacao = classificarNumero(num);
			exibirResultado(num, classificacao);
		}
	}

	private static int gerarNumeroAleatorio(Random gerador) {
		return gerador.nextInt(100);
	}

	private static String classificarNumero(int numero) {
		return (numero % 2 == 0) ? "PAR" : "ÍMPAR";
	}

	private static void exibirResultado(int numero, String classificacao) {
		System.out.printf("Número gerado: %d -> %s%n", numero, classificacao);
	}
}
